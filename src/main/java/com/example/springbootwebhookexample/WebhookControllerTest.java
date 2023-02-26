package com.example.springbootwebhookexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebhookControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHandleWebhook() {
        String payload = "{\"eventName\":\"user.created\",\"data\":{\"userId\":123,\"username\":\"john\"}}";

        ResponseEntity<String> response = restTemplate.postForEntity("/webhook", payload, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Webhook received!");
    }

}
