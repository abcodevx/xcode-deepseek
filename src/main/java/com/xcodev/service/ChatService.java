package com.xcodev.service;

import java.io.IOException;

/**
 * 对话服务层
 *
 * @author xCode
 * @date 2025/1/26
 **/

public interface ChatService {

    /**
     * 发送消息
     *
     * @param message 消息
     * @return {@link String} deepseek响应的消息
     */
    String send(String user, String message) throws IOException;
}
