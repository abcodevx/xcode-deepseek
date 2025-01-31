package com.xcodev.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 消息
 *
 * @author xCode
 * @date 2025/1/26
 **/

@Data
@Accessors(chain = true)
public class ChatMessage {

    /**
     * 模型
     */
    private String model;

    /**
     * 消息主题
     */
    private List<MessageContext> messages;

    /**
     *
     */
    private boolean stream;

    @Data
    @Accessors
    public static class MessageContext {
        private String role;
        private String content;
    }

}
