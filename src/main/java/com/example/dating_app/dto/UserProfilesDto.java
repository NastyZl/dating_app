package com.example.dating_app.dto;

import com.example.dating_app.entity.UserEntity;
import com.example.dating_app.enums.ZodiacSign;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class UserProfilesDto {
    private Long id;
    private UserEntity userId;
    private String name;
    private Integer age;
    private String photo;
    private String city;
    private Integer height;
    private String description;
    private ZodiacSign zodiacSign;
}
