package com.example.dating_app.service;


import com.example.dating_app.dto.UserProfilesDto;
import com.example.dating_app.entity.UserProfileEntity;

public interface UserProfileService {
    UserProfileEntity createUserProfile(UserProfileEntity userProfilesDto);
    UserProfileEntity getUserProfileById(Long user_id);
}
