package com.example.GitFetchV3;

import com.example.exceptionHandler.exceptions.UserNotFoundException;
import com.example.model.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc

public class FetchControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    void getUserRepositories() throws Exception{
        this.mockMvc.perform(get("/api/v1/sblorenc")).andExpect(status().isOk());

    }
    @Test
    void notFoundException() throws Exception{
        this.mockMvc.perform(get("/api/v1/sblorenc1")).andExpect(status().isNotFound());
    }

}
