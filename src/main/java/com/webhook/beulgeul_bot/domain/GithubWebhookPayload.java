package com.webhook.beulgeul_bot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.webhook.beulgeul_bot.domain.Discussion;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubWebhookPayload {
    private String action;
    private Discussion discussion;
}
