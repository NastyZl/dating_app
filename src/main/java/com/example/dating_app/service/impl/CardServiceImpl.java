package com.example.dating_app.service.impl;

import com.example.dating_app.dto.UserProfilesDto;
import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.repository.UserProfileRepository;
import com.example.dating_app.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final UserProfileRepository userProfileRepository;

    @Override
    public UserProfileEntity dislikeNextCard() {
        Long id = 1L;
        var userProfile = userProfileRepository.findById(id);
        return userProfile.get();
    }
}
