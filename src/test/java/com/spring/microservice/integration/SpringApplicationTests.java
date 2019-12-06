package com.spring.microservice.integration;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.spring.microservice.MicroserviceApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MicroserviceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SpringApplicationTests
{

    public static final String BASE_URL = "http://localhost:7990";


    @Test
    public void testValidInput()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponseTest> responseEntity =
            restTemplate
                .getForEntity(BASE_URL + "/api/user", UserResponseTest.class);
        log.info("responseEntity: {}", responseEntity);
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertNotNull(responseEntity.getBody());
    }
}
