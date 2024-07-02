package com.example.dating_app.service;


import com.example.dating_app.dto.UserDetailsDto;
import com.example.dating_app.dto.UserProfileDto;
import com.example.dating_app.dto.UserProfileDto;
import com.example.dating_app.entity.UserProfileEntity;

public interface UserProfileService {
    void createUserProfile(UserDetailsDto userDetailsDto, String login);
    UserProfileDto getUserProfileByLogin(String login);
}
