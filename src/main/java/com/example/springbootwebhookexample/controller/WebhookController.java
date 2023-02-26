package com.example.springbootwebhookexample.controller;

import com.example.springbootwebhookexample.WebhookPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("webhook")
    public ResponseEntity<String> handleWebhook(@RequestBody String payload) throws JsonProcessingException {
        WebhookPayload webhookPayload = objectMapper.readValue(payload, WebhookPayload.class);
        System.out.println("Received webhook payload: " + webhookPayload);
        return ResponseEntity.ok("Webhook received!");
    }
}
