package com.webhook.beulgeul_bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class MattermostService {

    @Value("${mattermost-webhook-url}")
    private String mattermostWebhookUrl;

    public void sendMessage(String message) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("text", message);
        restTemplate.postForEntity(mattermostWebhookUrl, requestBody, Void.class);
    }
}
