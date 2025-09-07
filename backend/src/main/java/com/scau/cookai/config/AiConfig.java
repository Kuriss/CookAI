package com.scau.cookai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiEmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public VectorStore vectorStore(OpenAiEmbeddingModel embeddingModel) {
        return SimpleVectorStore.builder(embeddingModel).build();
    }

    @Bean
    public ChatClient chatClient(OpenAiChatModel openAiChatModel) {
        return ChatClient.builder(openAiChatModel)
                .defaultSystem("你是一个智能助手")
                .build();
    }
    @Bean
    public ChatMemory chatMemory() {
        ChatMemory chatMemory = MessageWindowChatMemory
                .builder()
                .maxMessages(5)
                .build();
        return chatMemory;
    }

    @Bean
    public ChatClient foodChatClient(OpenAiChatModel openAiChatModel
            ,ChatMemory chatMemory,VectorStore vectorStore) {
        return ChatClient.builder(openAiChatModel)
                .defaultSystem("你是一位大厨，请根据我以下提供的菜谱信息，回答用户的问题")
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(chatMemory).build()
                        ,new SimpleLoggerAdvisor()
                        , QuestionAnswerAdvisor.builder(vectorStore)
                                .searchRequest(SearchRequest.builder()
                                        .topK(3)
                                        .similarityThreshold(0.1)
                                        .build()
                                )
                                .build()
                )
                .build();
    }
}
