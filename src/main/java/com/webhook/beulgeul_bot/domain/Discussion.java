package com.webhook.beulgeul_bot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Discussion {
    private Category category;
    private String title;
    private String body;
    private String html_url;
    private User user;
}