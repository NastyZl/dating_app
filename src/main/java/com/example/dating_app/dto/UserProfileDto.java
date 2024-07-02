package com.example.dating_app.dto;

import com.example.dating_app.enums.ZodiacSign;
import lombok.Data;

@Data
public class UserProfileDto {
    private Long id;
    private Long userId;
    private String name;
    private Integer age;
    private String photo;
    private String city;
    private Integer height;
    private String description;
    private ZodiacSign zodiacSign;
}