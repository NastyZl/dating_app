package com.example.dating_app.service;

import com.example.dating_app.dto.UserProfilesDto;
import com.example.dating_app.entity.UserProfileEntity;

public interface CardService {
    UserProfilesDto dislikeNextCard(UserProfileEntity userProfileEntity);

    UserProfilesDto likeNextCard(UserProfileEntity myUserProfileEntity, UserProfileEntity likedUserProfileEntity);

}
