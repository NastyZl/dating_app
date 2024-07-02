package com.example.dating_app.dto;

import com.example.dating_app.entity.UserEntity;
import lombok.Data;

@Data
public class LikeDto {
    private Long userId;
    private Long likedUserId;
}