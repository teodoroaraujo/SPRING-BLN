package com.spring.microservice.service.impl;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.microservice.response.UserComment;
import com.spring.microservice.response.UserResponse;
import com.spring.microservice.service.SpringService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpringServiceImpl implements SpringService
{

    private static final String USER_URL = "http://jsonplaceholder.typicode.com/users/1";
    private static final String COMMENT_URL = "http://jsonplaceholder.typicode.com/posts?userId=1";
    private RestTemplate restTemplate = new RestTemplate();
    
    
    @Override
    @Async
    public CompletableFuture<UserResponse> getUser()
    {
        log.info("Get user with url {}", USER_URL);
        UserResponse results = restTemplate.getForObject(USER_URL, UserResponse.class);
        
        return CompletableFuture.completedFuture(results);
    }
    
    @Async
    public CompletableFuture<UserResponse> getCommentByUser(UserResponse user) {
        log.info("Get comments with url {}", COMMENT_URL);
        UserComment[] comments = restTemplate.getForObject(COMMENT_URL, UserComment[].class);
        user.setComments(Arrays.asList(comments));
        return CompletableFuture.completedFuture(user);
    }
}
