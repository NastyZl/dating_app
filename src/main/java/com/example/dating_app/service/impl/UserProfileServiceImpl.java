package com.example.dating_app.service.impl;

import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.exception.UserNotFoundException;
import com.example.dating_app.exception.UserProfileNotFoundException;
import com.example.dating_app.repository.UserProfileRepository;
import com.example.dating_app.repository.UserRepository;
import com.example.dating_app.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public UserProfileEntity getUserProfileById(Long id) {
        var userProfile = userProfileRepository.findById(id);
        if (userProfile.isEmpty()) {
            throw new UserProfileNotFoundException("user with id " + id + " not found");
        }

        return userProfile.get();
    }

    @Override
    public void deleteUserProfileById(Long id) {
        if (userProfileRepository.findById(id).isEmpty()) {
            throw new UserProfileNotFoundException("user with id " + id + " not found");
        }

        userProfileRepository.deleteById(id);
    }

    @Override
    public UserProfileEntity updateUserProfileById(UserProfileEntity userProfilesDto, Long id) {
        var userProfile = userProfileRepository.findById(id);

        if (userProfile.isEmpty()) {
            throw new UserProfileNotFoundException("user with id " + id + " not found");
        }

        return userProfileRepository.save(userProfilesDto);
    }
}
