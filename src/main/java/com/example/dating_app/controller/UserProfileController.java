package com.example.dating_app.controller;

import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("profile")
public class UserProfileController {
    private final UserProfileService userProfileService;


    @PostMapping("create")
    public UserProfileEntity createUserProfile(@RequestBody UserProfileEntity userProfileEntity) {
        return userProfileService.createUserProfile(userProfileEntity);
    }

    @GetMapping("{id}")
    public UserProfileEntity updateUserProfile(@PathVariable Long id) {
        return userProfileService.getUserProfileById(id);
    }

}
