package com.example.dating_app.service.impl;

import com.example.dating_app.dto.UserProfilesDto;
import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.exception.UserNotFoundException;
import com.example.dating_app.repository.UserProfileRepository;
import com.example.dating_app.repository.UserRepository;
import com.example.dating_app.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    @Override
    public UserProfileEntity createUserProfile(UserProfileEntity userProfilesDto) {
        var existingUserAccount = userRepository.findById(userProfilesDto.getUserId().getId());

        if (existingUserAccount.isEmpty()) {
            throw new UserNotFoundException("user not found");
        }

        return userProfileRepository.save(userProfilesDto);
    }

    @Override
    public UserProfileEntity getUserProfileById(Long user_id) {
        var userProfile = userProfileRepository.findById(user_id);
        if (userProfile.isEmpty()) {
            throw new UserNotFoundException("user with id " + user_id + "not found");
        }

        return userProfile.get();
    }
}
