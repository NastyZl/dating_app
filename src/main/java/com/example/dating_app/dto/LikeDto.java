package com.example.dating_app.dto;

import lombok.Data;

@Data
public class LikeDto {
    private Long userId;
    private Long likedUserId;
}