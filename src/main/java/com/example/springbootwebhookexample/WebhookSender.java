package com.example.springbootwebhookexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class WebhookSender {
    private final OkHttpClient httpClient = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void sendWebhook(String url, String event, Map<String, Object> data) throws IOException {
        WebhookPayload webhookPayload = new WebhookPayload();
        webhookPayload.setEventName(event);
        webhookPayload.setData(data);

        String payload = objectMapper.writeValueAsString(webhookPayload);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), payload);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        Response response = httpClient.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unexpected HTTP status code." + response.code());
        }

    }
}
