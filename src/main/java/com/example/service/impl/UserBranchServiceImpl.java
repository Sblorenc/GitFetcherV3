package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.model.Branch;
import com.example.service.UserBranchService;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class UserBranchServiceImpl implements UserBranchService{

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private String url;

    @Autowired
    private ApiConnectionServiceImpl apiConnectionServiceImpl;


    public List<Branch>getUserBranches(String username, String repoName){
        String apiUrl = url+"repos/"+username+"/"+repoName+"/branches";
        JsonNode root = apiConnectionServiceImpl.connect(apiUrl);

        List<Branch>listOfBranches = new ArrayList<>();
        StreamSupport.stream(root.spliterator(), false)
        .forEach(e -> listOfBranches.add(new Branch(e.get("name").asText(),e.get("commit").get("sha").asText())));
        return listOfBranches;
    }
}
