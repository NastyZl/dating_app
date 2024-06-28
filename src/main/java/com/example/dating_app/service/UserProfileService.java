package com.example.dating_app.service;


import com.example.dating_app.entity.UserProfileEntity;
import org.springframework.http.ResponseEntity;

public interface UserProfileService {
    UserProfileEntity createUserProfile(UserProfileEntity userProfilesDto);
    UserProfileEntity getUserProfileById(Long user_id);
    void deleteUserProfileById(Long user_id);
    UserProfileEntity updateUserProfileById(UserProfileEntity userProfilesDto, Long id);
}
