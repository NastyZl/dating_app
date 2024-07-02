package com.example.dating_app.dto;

import com.example.dating_app.entity.UserContactEntity;
import com.example.dating_app.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchDto {
    private Long id;
    private String login;
    private String telegram;
    private String phoneNumber;
}