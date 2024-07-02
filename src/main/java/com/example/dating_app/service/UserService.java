package com.example.dating_app.service;

import com.example.dating_app.dto.UserDetailsDto;
import com.example.dating_app.dto.UserDto;
import com.example.dating_app.exception.UserNotFoundException;

public interface UserService {
    UserDto findById(Long id) throws UserNotFoundException;

    UserDto findByLogin(String login) throws UserNotFoundException;

    UserDetailsDto findUserDetails(String login) throws UserNotFoundException;
}
