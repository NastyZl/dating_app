package com.example.dating_app.controller;

import com.example.dating_app.dto.UserDetailsDto;
import com.example.dating_app.dto.UserProfileDto;
import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.service.UserProfileService;
import com.example.dating_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("profile")
public class UserProfileController {
    private final UserProfileService userProfileService;
    private final UserService userService;

    @PostMapping("create")
    public ResponseEntity createUserProfile(@RequestBody UserDetailsDto userDetailsDto, Principal principal) {
        userProfileService.createUserProfile(userDetailsDto, principal.getName());
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public UserProfileDto getUserProfile(Principal principal) {
        return userProfileService.getUserProfileByLogin(principal.getName());
    }

    @GetMapping("my-profile")
    public ResponseEntity<UserDetailsDto> getMyProfile(Principal principal) {
        return ResponseEntity.ok(userService.findUserDetails(principal.getName()));
    }
}
