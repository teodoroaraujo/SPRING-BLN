package com.spring.microservice.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
}
