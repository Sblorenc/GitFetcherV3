package com.example.model;

import org.springframework.stereotype.Component;

@Component
public class Branch {

    String branchName;
    String commitSha;

    public Branch(String branchName, String commitSha){
        this.branchName = branchName;
        this.commitSha = commitSha;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCommitSha() {
        return commitSha;
    }

    public void setCommitSha(String commitSha) {
        this.commitSha = commitSha;
    }
    
}
