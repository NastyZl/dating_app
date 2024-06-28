package com.example.dating_app.dto;

import com.example.dating_app.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class LikesDto {
    private Long id;
    private UserEntity userId;
    private UserEntity likedUserId;
}
