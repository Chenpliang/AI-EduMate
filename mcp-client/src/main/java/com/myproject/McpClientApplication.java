package com.myproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.customizer.McpSyncClientCustomizer;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class McpClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpClientApplication.class, args);
	}

	@Bean
	public ChatClient chatClient(ChatClient.Builder chatClientBuilder, ToolCallbackProvider tools){
		return chatClientBuilder
				.defaultToolCallbacks(tools)
				.build();
	}
}
