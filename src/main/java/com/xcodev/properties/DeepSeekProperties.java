package com.xcodev.properties;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置类
 *
 * @author xCode
 * @date 2025/1/26
 **/

@Data
@ToString
@Component
@ConfigurationProperties(prefix = "deepseek")
public class DeepSeekProperties {

    private String model;

    private String url;

    private String apiKey;
}
