package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Branch;

@Service
public interface UserBranchService {

    List<Branch>getUserBranches(String username, String repoName);
}
