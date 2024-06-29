package com.example.dating_app.dto;

import com.example.dating_app.entity.UserEntity;
import lombok.Data;

@Data
public class MatchDto {
    private Long id;
    private UserEntity firstUserId;
    private UserEntity secondUserId;
}
