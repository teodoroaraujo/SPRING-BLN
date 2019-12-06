package com.spring.microservice.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservice.response.UserResponse;
import com.spring.microservice.service.SpringService;

@RestController
@RequestMapping("/api")
public class SpringController
{
    @Autowired
    private SpringService springService;


    @GetMapping("/user")
    public CompletableFuture<UserResponse> getUser()
    {
        return springService
            .getUser()
            .thenCompose(springService::getCommentByUser);
    }

}
