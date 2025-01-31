package com.xcodev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * DeepSeek测试工程
 *
 * @author xCode
 * @date 2025/1/26
 **/

@ConfigurationProperties
@SpringBootApplication
public class XCodevDeepSeekApplication {
    public static void main(String[] args) {
        SpringApplication.run(XCodevDeepSeekApplication.class, args);
    }
}
