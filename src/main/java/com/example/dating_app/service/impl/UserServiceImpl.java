package com.example.dating_app.service.impl;

import com.example.dating_app.dto.UserDetailsDto;
import com.example.dating_app.dto.UserDto;
import com.example.dating_app.entity.UserEntity;
import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.exception.UserNotFoundException;
import com.example.dating_app.mapper.UserMapper;
import com.example.dating_app.repository.UserProfileRepository;
import com.example.dating_app.repository.UserRepository;
import com.example.dating_app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final UserMapper userMapper;


    @Override
    public UserDto findById(Long id) throws UserNotFoundException {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent())
            return userMapper.userEntityToUserDto(user.get());
        else throw new UserNotFoundException("user not found");
    }

    @Override
    public UserDto findByLogin(String login) throws UserNotFoundException {
        Optional<UserEntity> user = userRepository.findByLogin(login);
        if (user.isPresent())
            return userMapper.userEntityToUserDto(user.get());
        else throw new UserNotFoundException("user not found");
    }

    @Override
    public UserDetailsDto findUserDetails(String login) throws UserNotFoundException {
        return userRepository.findByLogin(login)
                .map(userEntity -> userProfileRepository.findUserProfileByUserId(userEntity.getId())
                        .map(profile -> mapper(login, profile))
                        .orElseThrow(() -> new UserNotFoundException("User profile not found")))
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    private UserDetailsDto mapper(String login, UserProfileEntity profile) {
        return Stream.of(profile)
                .map(p -> new UserDetailsDto(
                        login,
                        "",
                        "",
                        p.getDescription(),
                        p.getName(),
                        p.getAge(),
                        p.getZodiacSign().getRussianName(),
                        p.getPhoto(),
                        p.getCity(),
                        p.getHeight()
                ))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("ERROR to map UserProfileEntity to UserDetailsDto"));
    }

}
