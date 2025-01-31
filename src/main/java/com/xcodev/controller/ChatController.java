package com.xcodev.controller;

import com.xcodev.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 对话测试类
 *
 * @author xCode
 * @date 2025/1/26
 **/

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/send")
    public String send(String user, String message) {
        try {
            return chatService.send(user, message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
