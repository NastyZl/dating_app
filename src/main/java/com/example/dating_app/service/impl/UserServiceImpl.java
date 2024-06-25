package com.example.dating_app.service.impl;

import com.example.dating_app.dto.UserDto;
import com.example.dating_app.entity.UserEntity;
import com.example.dating_app.exception.UserNotFoundException;
import com.example.dating_app.mapper.UserMapper;
import com.example.dating_app.repository.UserRepository;
import com.example.dating_app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto findById(Long id) throws UserNotFoundException {
        Optional<UserEntity> byId = userRepository.findById(id);
        if (byId.isPresent())
            return userMapper.userEntityToUserDto(byId.get());
        else throw new UserNotFoundException("user not found");
    }
}
