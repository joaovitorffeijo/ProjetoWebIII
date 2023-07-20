package com.projetoweb3.projeto.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetoweb3.projeto.model.ChatGPTMessage;
import com.projetoweb3.projeto.model.ChatGPTRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class ChatGPTService {

    @Value("${openai.api.key}")
    private String apiKey;

    public String careerDescription(String userMessage) {
        String url = "https://api.openai.com/v1/chat/completions";

        HttpHeaders headers = createHttpHeaders();
        ChatGPTRequest chatGPTRequest = createChatGPTRequest(userMessage);

        HttpEntity<ChatGPTRequest> requestEntity = new HttpEntity<>(chatGPTRequest, headers);
        ResponseEntity<String> responseEntity = sendChatGPTRequest(url, requestEntity);

        String responseBody = responseEntity.getBody();
        if (responseBody != null) {
            return parseChatGPTResponse(responseBody);
        }

        return "Error processing the response.";
    }

    private HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);
        return headers;
    }

    private ChatGPTRequest createChatGPTRequest(String userMessage) {
        ChatGPTMessage userChatGPTMessage = new ChatGPTMessage("user", "Comente de forma curta e objetiva (máx 2 parágrafos) a carreira do artista a seguir com base na sua discografia: " + userMessage);
        List<ChatGPTMessage> messages = Collections.singletonList(userChatGPTMessage);

        ChatGPTRequest chatGPTRequest = new ChatGPTRequest();
        chatGPTRequest.setModel("gpt-3.5-turbo");
        chatGPTRequest.setMessages(messages);
        chatGPTRequest.setTemperature(0);
        chatGPTRequest.setMaxTokens(256);
        return chatGPTRequest;
    }

    private ResponseEntity<String> sendChatGPTRequest(String url, HttpEntity<ChatGPTRequest> requestEntity) {
        return new RestTemplate().postForEntity(url, requestEntity, String.class);
    }

    private String parseChatGPTResponse(String responseBody) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseBody);
            JsonNode assistantMessageNode = rootNode.at("/choices/0/message/content");
            return assistantMessageNode.asText();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error processing the response.";
    }
}

