package com.webhook.beulgeul_bot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhook.beulgeul_bot.domain.GithubWebhookPayload;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GithubWebhookLambdaFunction implements Function<String, String> {

    private final MattermostService mattermostService;

    private ObjectMapper objectMapper = new ObjectMapper();

    public GithubWebhookLambdaFunction(MattermostService mattermostService) {
        this.mattermostService = mattermostService;
    }

    @Override
    public String apply(String input) {
        try {
            GithubWebhookPayload payload = objectMapper.readValue(input, GithubWebhookPayload.class);

            if (payload == null || payload.getDiscussion() == null || payload.getDiscussion().getCategory() == null || payload.getDiscussion().getUser() == null) {
                throw new RuntimeException("Invalid payload structure");
            }

            if ("created".equals(payload.getAction())) {
                String category = payload.getDiscussion().getCategory().getName();
                String title = payload.getDiscussion().getTitle();
                String body = payload.getDiscussion().getBody();
                if (body.length() > 100) {
                    body = body.substring(0, 100) + "...";
                }
                String url = payload.getDiscussion().getHtml_url();
                String user = payload.getDiscussion().getUser().getLogin();
                String message = String.format(
                        ":round_pushpin: **%s**님의 새 글을 확인하세요 ! :round_pushpin:" +
                                "\n[%s](%s)",
                        user, title, url);
                mattermostService.sendMessage(message);
            }
            return "Message sent successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing webhook: " + e.getMessage();
        }
    }
}