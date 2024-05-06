package com.example.service.impl;

import com.example.service.ApiConnectionService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ApiConnectionServiceImpl implements ApiConnectionService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public JsonNode connect(String url){
                JsonNode jsonNode = webClientBuilder
                        .build()
                        .get()
                        .uri(url)
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToMono(JsonNode.class)
                        .block();
                return jsonNode;
    }
}
