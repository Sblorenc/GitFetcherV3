package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.UserRepository;

@Service
public interface UserRepositoryService {

    List<UserRepository> getUserData(String username);
}
