package com.webhook.beulgeul_bot.handler;

import org.springframework.cloud.function.adapter.aws.FunctionInvoker;

public class LambdaHandler extends FunctionInvoker {
    private static final String EXECUTE_HANDLER = "githubWebhookLambdaFunction";

    public LambdaHandler() {
        super(EXECUTE_HANDLER);
    }
}
