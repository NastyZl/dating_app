package com.example.dating_app.service.impl;

import com.example.dating_app.dto.UserProfilesDto;
import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.mapper.UserProfileMapper;
import com.example.dating_app.repository.LikesRepository;
import com.example.dating_app.repository.MatchRepository;
import com.example.dating_app.repository.UserProfileRepository;
import com.example.dating_app.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final UserProfileRepository userProfileRepository;
    private final LikesRepository likesRepository;
    private final MatchRepository matchRepository;
    private final UserProfileMapper userProfileMapper;

    @Override
    public UserProfilesDto dislikeNextCard(UserProfileEntity userProfileEntity) {

        Long id = findCorrectUserId(userProfileEntity);
        Optional<UserProfileEntity> userProfile = userProfileRepository.findById(id);
        UserProfilesDto userProfilesDto = userProfileMapper.userEntityToUserDto(userProfile.get());
        userProfilesDto.setUserId(null);
        return userProfilesDto;
    }

    @Override
    public UserProfilesDto likeNextCard(UserProfileEntity myUserProfileEntity, UserProfileEntity likedUserProfileEntity) {
        if (likesRepository.checkIfUserIdExistsInLikedUserIdWithUser(myUserProfileEntity.getId(), likedUserProfileEntity.getId())) {
            likesRepository.deleteByLikedUserIdAndUserId(myUserProfileEntity.getId(), likedUserProfileEntity.getId());
            matchRepository.createMatch(myUserProfileEntity.getId(), likedUserProfileEntity.getId());
        }
        else {
            likesRepository.createLike(myUserProfileEntity.getId(), likedUserProfileEntity.getId());
        }

        Long id = findCorrectUserId(myUserProfileEntity);
        Optional<UserProfileEntity> userProfile = userProfileRepository.findById(id);
        UserProfilesDto userProfilesDto = userProfileMapper.userEntityToUserDto(userProfile.get());
        userProfilesDto.setUserId(null);
        return userProfilesDto;
    }

    private Long findCorrectUserId(UserProfileEntity userProfileEntity) {
        Long idMaxValue = userProfileRepository.getMaxUserId();
        Long currentUserId = userProfileEntity.getId();
        Long randomUserId = randomUserId(idMaxValue);
        while (isRandomUserIdNotCorrect(randomUserId, currentUserId)) {
            randomUserId = randomUserId(idMaxValue);
        }
        return randomUserId;
    }

    private Long randomUserId(Long idMaxValue) {
        Random random = new Random();
        return random.nextLong((idMaxValue - 1) + 1) + 1;
    }

    private boolean isRandomUserIdNotCorrect(Long randomUserId, Long currentUserId) {
        return randomUserId.equals(currentUserId);
    }
}
