package com.webhook.beulgeul_bot;

import com.webhook.beulgeul_bot.domain.GithubWebhookPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// GitHub Webhook 이벤트를 처리하는 컨트롤러
// AWS 람다 사용으로 미사용 하게 됨..
@RestController
@RequestMapping("/github-webhook")
public class BgController {

    private final MattermostService mattermostService;

    public BgController(MattermostService mattermostService) {
        this.mattermostService = mattermostService;
    }

    @PostMapping
    public ResponseEntity<Void> handleGithubWebhook(@RequestBody GithubWebhookPayload payload) {
        if (payload.getAction().equals("created")) {
            String category = payload.getDiscussion().getCategory().getName();
            String title = payload.getDiscussion().getTitle();
            String body = payload.getDiscussion().getBody();
            if(body.length() > 100) {
                body = body.substring(0, 100) + "...";
            }
            String url = payload.getDiscussion().getHtml_url();
            String user = payload.getDiscussion().getUser().getLogin();
            String message = String.format(
                    ":round_pushpin: **%s**님의 새 글을 확인하세요 ! :round_pushpin:" +
                            "\n[%s](%s)"
                    ,user, title, url);
            mattermostService.sendMessage(message);
        }
        return ResponseEntity.ok().build();
    }
}




