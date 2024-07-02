package com.example.dating_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDetailsDto {
    private String login;
    private String telegram;
    private String phoneNumber;
    private String description;
    private String name;
    private Integer age;
    private String zodiacSign;
    private String photoUrl;
    private String city;
    private Integer height;
}