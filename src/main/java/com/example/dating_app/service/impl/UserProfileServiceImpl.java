package com.example.dating_app.service.impl;

import com.example.dating_app.dto.UserDetailsDto;
import com.example.dating_app.dto.UserProfileDto;
import com.example.dating_app.exception.UserNotFoundException;
import com.example.dating_app.mapper.UserContactMapper;
import com.example.dating_app.mapper.UserProfileMapper;
import com.example.dating_app.repository.UserContactRepository;
import com.example.dating_app.repository.UserProfileRepository;
import com.example.dating_app.repository.UserRepository;
import com.example.dating_app.service.UserProfileService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final UserContactRepository userContactRepository;
    private final UserProfileMapper userProfileMapper;
    private final UserContactMapper userContactMapper;

    @Override
    @Transactional
    public void createUserProfile(UserDetailsDto userDetailsDto, String login) {

        var userAccount = userRepository.findByLogin(login);
        userProfileRepository.save(userProfileMapper.mapUserDetailsDtoToUserProfileEntity(userDetailsDto, userAccount.get()));
        userContactRepository.save(userContactMapper.mapUserDetailsDtoToUserContactEntity(userDetailsDto, userAccount.get()));
    }

    @Override
    public UserProfileDto getUserProfileByLogin(String login) {

        var user = userRepository.findByLogin(login);

        var userProfile = userProfileRepository.findById(user.get().getId());


        if (userProfile.isEmpty()) {
            throw new UserNotFoundException("user " + login + " dont have profile");
        }

        return userProfileMapper.mapUserProfileEntityToUserProfileDto(userProfile.get());
    }
}
