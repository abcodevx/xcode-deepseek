package com.xcodev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 对象返回信息
 *
 * @author xCode
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

 
    @Data
    @NoArgsConstructor
    public static class Choice {
        private String finishReason;
        private int index;
        private Message message;
        private LogProbs logprobs;


        @Data
        @NoArgsConstructor
        public static class Message {
            private String content;
            private String reasoningContent;
            private List<ToolCall> toolCalls;
            private String role;

            @Data
            @NoArgsConstructor
            public static class ToolCall {
                private String id;
                private String type;
                private Function function;
                
                @Data
                @NoArgsConstructor
                public static class Function {
                    private String name;
                    private String arguments;
                }
            }
        }

        @Data
        @NoArgsConstructor
        public static class LogProbs {
            private List<ContentLog> content;
            
            @Data
            @NoArgsConstructor
            public static class ContentLog {
                private String token;
                private double logprob;
                private List<Integer> bytes;
                private List<TopLogProb> topLogprobs;


                @Data
                @NoArgsConstructor
                public static class TopLogProb {
                    private String token;
                    private double logprob;
                    private List<Integer> bytes;
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

        @Data
        @NoArgsConstructor
        public static class CompletionTokensDetails {
            private int reasoningTokens;

        }
    }
}
