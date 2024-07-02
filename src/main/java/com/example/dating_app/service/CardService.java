package com.example.dating_app.service;

import com.example.dating_app.dto.UserProfilesDto;
import com.example.dating_app.entity.UserProfileEntity;

import java.security.Principal;

public interface CardService {
    UserProfilesDto dislikeNextCard(Principal principal);

    UserProfilesDto likeNextCard(UserProfileEntity likedUserProfileEntity, Principal principal);


    void createLike(UserProfileEntity userProfileEntity, String login);


    void createMatch(UserProfileEntity userProfileEntity, String login);
}
