package com.xcodev.service;

import java.io.IOException;

/**
 * 对话服务层
 *
 * @author xCode
 **/

public interface ChatService {

    /**
     * 发送消息
     *
     * @param user    用户
     * @param message 消息
     * @return {@link String} deepseek响应的消息
     * @throws IOException ioexception
     */
    String send(String user, String message) throws IOException;
}
