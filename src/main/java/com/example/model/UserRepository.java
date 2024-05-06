package com.example.model;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserRepository {
    private String owner;
    private String repoName;
    private List<Branch> branchList;

    public UserRepository(String repoName, String owner, List<Branch> branchList){
        this.repoName = repoName;
        this.owner = owner;
        this.branchList = branchList;
    }


    public String getRepoName() {
        return repoName;
    }


    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }


    public String getOwner() {
        return owner;
    }


    public void setOwner(String owner) {
        this.owner = owner;
    }


    public List<Branch> getBranchList() {
        return branchList;
    }


    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    
    

}
