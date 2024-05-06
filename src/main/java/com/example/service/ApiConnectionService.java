package com.example.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

@Service
public interface ApiConnectionService {

    JsonNode connect(String url);
}
