package com.example.dating_app.controller;

import com.example.dating_app.dto.UserDto;
import com.example.dating_app.exception.UserNotFoundException;
import com.example.dating_app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1.0/dating")
public class AuthController {

    private final UserService userService;

    @GetMapping(value = "/{userId}")
    public String findById(@PathVariable Long userId) throws UserNotFoundException {
        UserDto userDto = userService.findById(userId);
        return userDto.getLogin();
    }

    @GetMapping(value = "/test")
    public String findById() {
        return "top";
    }
}
