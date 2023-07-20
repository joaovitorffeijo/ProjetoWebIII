package com.projetoweb3.projeto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projetoweb3.projeto.model.ChatGPTMessage;

import java.util.List;

public class ChatGPTRequest {

    @JsonProperty("model")
    private String model;

    @JsonProperty("messages")
    private List<ChatGPTMessage> messages;

    @JsonProperty("temperature")
    private double temperature;

    @JsonProperty("max_tokens")
    private int maxTokens;

    public ChatGPTRequest() {

    }

    public ChatGPTRequest(String model, List<ChatGPTMessage> messages, double temperature, int maxTokens) {
        this.model = model;
        this.messages = messages;
        this.temperature = temperature;
        this.maxTokens = maxTokens;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ChatGPTMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatGPTMessage> messages) {
        this.messages = messages;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }
}

