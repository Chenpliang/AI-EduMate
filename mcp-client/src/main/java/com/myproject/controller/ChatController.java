package com.myproject.controller;

import com.myproject.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
@Slf4j
public class ChatController {

    private final ChatClient chatClient;

    @Autowired
    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/chat")
    public String chat(Model model) {
        return "chat";
    }

    @GetMapping("/chat2")
    public String chat2(Model model) {
        return "chat2";
    }

    @GetMapping("/video")
    public String video(Model model) {
        return "video";
    }

    @MessageMapping("/send.message")
    @SendTo("/topic/public.messages")
    public Message handleChatMessage(Message message) {
        log.info("Received user message: {}", message.getContent());

        try {
            // 测试用固定响应
            // return new Message("这是测试响应", false);

            String botResponse = chatClient.prompt()
                    .user(message.getContent())
                    .call()
                    .content();

            log.info("Generated response: {}", botResponse);
            return new Message(botResponse, false);
        } catch (Exception e) {
            log.error("Error processing message", e);
            return new Message("处理请求时出错: " + e.getMessage(), false);
        }
    }
}