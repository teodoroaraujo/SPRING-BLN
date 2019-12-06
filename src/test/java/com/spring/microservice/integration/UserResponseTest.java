package com.spring.microservice.integration;

import java.util.List;

import com.spring.microservice.response.UserComment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponseTest
{
    
    private Integer id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
    private List<UserComment> comments;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Address
    {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Geo
    {
        private String lat;
        private String lng;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Company
    {
        private String name;
        private String catchPhrase;
        private String bs;
    }

}
