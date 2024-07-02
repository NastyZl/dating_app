package com.example.dating_app.service;

import com.example.dating_app.dto.UserProfileDto;
import com.example.dating_app.entity.UserProfileEntity;

import java.security.Principal;

public interface CardService {
    UserProfileDto dislikeNextCard(Principal principal);

    UserProfileDto likeNextCard(UserProfileEntity likedUserProfileEntity, Principal principal);


    void createLike(UserProfileEntity userProfileEntity, String login);


    void createMatch(UserProfileEntity userProfileEntity, String login);
}
