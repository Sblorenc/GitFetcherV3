package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class AppConfig {

    @Bean
	public WebClient.Builder getWebClientBuilder (){
		return WebClient.builder();
	}

    @Bean
    public String apiUrl(){
        return "https://api.github.com/";
    }
    

}
