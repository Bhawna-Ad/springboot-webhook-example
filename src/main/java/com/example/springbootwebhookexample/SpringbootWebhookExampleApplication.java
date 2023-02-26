package com.example.springbootwebhookexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootWebhookExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebhookExampleApplication.class, args);
	}

	@Bean
	public WebhookSender webhookSenderBean() {
		return new WebhookSender();
	}

}
