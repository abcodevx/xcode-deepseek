package com.xcodev.service.impl;

import com.google.gson.Gson;
import com.xcodev.entity.ChatMessage;
import com.xcodev.entity.ChatResult;
import com.xcodev.properties.DeepSeekProperties;
import com.xcodev.service.ChatService;
import jakarta.annotation.Resource;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

/**
 * 对话服务层
 *
 * @author xCode
 * @date 2025/1/26
 **/

@Service
public class ChatServiceImpl implements ChatService {

    @Resource
    private DeepSeekProperties deepSeekProperties;

    @Override
    public String send(String user, String message) throws IOException {
        ChatMessage.MessageContext messageContext = new ChatMessage.MessageContext()
                .setRole(user)
                .setContent(message);
        ChatMessage chatMessage = new ChatMessage()
                .setModel(deepSeekProperties.getModel())
                .setStream(false)
                .setMessages(Collections.singletonList(messageContext));


        Request.Builder builder = new Request.Builder();
        Request request = builder.url(deepSeekProperties.getUrl())
                .addHeader("Authorization", "Bearer " + deepSeekProperties.getApiKey())
                .post(RequestBody.Companion.create(new Gson().toJson(chatMessage), MediaType.parse("application/json")))
                .build();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .writeTimeout(Duration.ofMinutes(2L))
                .readTimeout(Duration.ofMinutes(2L))
                .connectTimeout(Duration.ofMinutes(2L))
                .callTimeout(Duration.ofMinutes(2L))
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        ChatResult chatResult = new Gson().fromJson(response.body().string(), ChatResult.class);
        return chatResult.getChoices().get(0).getMessage().getContent();
    }
}
