package com.webhook.beulgeul_bot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String login;
}
