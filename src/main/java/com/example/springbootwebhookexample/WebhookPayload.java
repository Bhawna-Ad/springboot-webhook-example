package com.example.springbootwebhookexample;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class WebhookPayload {
    private String eventName;
    private Map<String, Object> data;
}
