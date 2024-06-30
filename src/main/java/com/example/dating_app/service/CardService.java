package com.example.dating_app.service;

import com.example.dating_app.dto.UserProfilesDto;
import com.example.dating_app.entity.UserProfileEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CardService {
    UserProfileEntity dislikeNextCard(UserProfileEntity userProfileEntity);

    UserProfileEntity likeNextCard(UserProfileEntity myUserProfileEntity, UserProfileEntity likedUserProfileEntity);

}
