package com.example.dating_app.dto;

import com.example.dating_app.entity.UserContactEntity;
import com.example.dating_app.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchDto {
    private UserEntity user;
    private UserContactEntity userContact;
}
