package com.xcodev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * DeepSeek测试工程
 *
 * @author xCode
 * @date 2025/1/26
 **/

@SpringBootApplication
@EnableConfigurationProperties
public class XcodevDeepSeekApplication {
    public static void main(String[] args) {
        SpringApplication.run(XcodevDeepSeekApplication.class, args);
    }
}
