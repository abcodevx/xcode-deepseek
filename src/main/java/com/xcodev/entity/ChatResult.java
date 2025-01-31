package com.xcodev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 对象返回信息
 *
 * @author xCode
 * @date 2025/1/26
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatResult {

    private String id;
    private List<Choice> choices;
    private long created;
    private String model;
    private String systemFingerprint;
    private String object;
    private Usage usage;

    // Getters and Setters
    @Data
    @NoArgsConstructor
    public static class Choice {
        private String finishReason;
        private int index;
        private Message message;
        private LogProbs logprobs;

        // Getters and Setters
        @Data
        @NoArgsConstructor
        public static class Message {
            private String content;
            private String reasoningContent;
            private List<ToolCall> toolCalls;
            private String role;

            // Getters and Setters
            @Data
            @NoArgsConstructor
            public static class ToolCall {
                private String id;
                private String type;
                private Function function;

                // Getters and Setters
                @Data
                @NoArgsConstructor
                public static class Function {
                    private String name;
                    private String arguments;

                    // Getters and Setters
                }
            }
        }

        public static class LogProbs {
            private List<ContentLog> content;

            // Getters and Setters
            @Data
            @NoArgsConstructor
            public static class ContentLog {
                private String token;
                private double logprob;
                private List<Integer> bytes;
                private List<TopLogProb> topLogprobs;

                // Getters and Setters
                @Data
                @NoArgsConstructor
                public static class TopLogProb {
                    private String token;
                    private double logprob;
                    private List<Integer> bytes;

                    // Getters and Setters
                }
            }
        }
    }

    @Data
    @NoArgsConstructor
    public static class Usage {
        private int completionTokens;
        private int promptTokens;
        private int promptCacheHitTokens;
        private int promptCacheMissTokens;
        private int totalTokens;
        private CompletionTokensDetails completionTokensDetails;

        // Getters and Setters
        @Data
        @NoArgsConstructor
        public static class CompletionTokensDetails {
            private int reasoningTokens;

            // Getters and Setters
        }
    }
}
