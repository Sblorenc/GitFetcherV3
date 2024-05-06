package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.model.UserRepository;
import com.example.service.UserRepositoryService;
import com.fasterxml.jackson.databind.JsonNode;


@Component
public class UserRepositoryServiceImpl implements UserRepositoryService {


    @Autowired
    private String url;

    @Autowired
    private UserBranchServiceImpl userBranchServiceImpl;

    @Autowired
    private ApiConnectionServiceImpl apiConnectionService;


   
    @Override
    public List<UserRepository>getUserData(String username){
        String apiUrl = url+"users/"+username+"/repos";
        JsonNode root= apiConnectionService.connect(apiUrl);

        List<UserRepository>userReposiriesList = new ArrayList<>();

        Stream<JsonNode>streamOfJson = StreamSupport.stream(root.spliterator(), false);
        streamOfJson
        .filter(r -> r.get("fork").asText().equals("false"))
        .forEach(r -> userReposiriesList.add(new UserRepository(r.get("name").asText()
        ,r.get("owner").get("login").asText()
        ,userBranchServiceImpl.getUserBranches(username,r.get("name").asText()))));

        return userReposiriesList;
    }

}
