package com.example.dating_app.service.impl;

import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.repository.UserProfileRepository;
import com.example.dating_app.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final UserProfileRepository userProfileRepository;

    @Override
    public UserProfileEntity dislikeNextCard(UserProfileEntity userProfileEntity) {
        Long id = findCorrectUserId(userProfileEntity);
        var userProfile = userProfileRepository.findById(id);
        return userProfile.get();
    }

    private Long findCorrectUserId(UserProfileEntity userProfileEntity) {
        Long idMaxValue = userProfileRepository.getMaxUserId();
        Long currentUserId = userProfileEntity.getUserId().getId();
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
