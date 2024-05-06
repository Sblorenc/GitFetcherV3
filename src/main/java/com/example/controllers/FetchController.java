package com.example.controllers;


import java.util.List;


import com.example.exceptionHandler.exceptions.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.UserRepository;
import com.example.service.impl.UserRepositoryServiceImpl;

import org.springframework.web.reactive.function.client.WebClientResponseException;


@RestController
@RequestMapping("api/v1")
public class FetchController {

    @Autowired
    private UserRepositoryServiceImpl userRepositoryServiceImpl;

    @GetMapping("/{username}")
    public ResponseEntity<List<UserRepository>> getUserData(@PathVariable String username){
        try {
            List<UserRepository> userRepositories = userRepositoryServiceImpl.getUserData(username);
            return ResponseEntity.ok(userRepositories);
        } catch (WebClientResponseException e){
            throw new UserNotFoundException();
        }
    }
}
