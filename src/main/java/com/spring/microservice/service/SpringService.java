package com.spring.microservice.service;

import java.util.concurrent.CompletableFuture;

import com.spring.microservice.response.UserResponse;

public interface SpringService
{

    CompletableFuture<UserResponse> getUser();


    CompletableFuture<UserResponse> getCommentByUser(UserResponse user);
}
