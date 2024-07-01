package com.example.dating_app.controller;

import com.example.dating_app.dto.MatchDto;
import com.example.dating_app.entity.MatchEntity;
import com.example.dating_app.entity.UserEntity;
import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.service.CardService;
import com.example.dating_app.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    @GetMapping("{id}")
    public List<MatchEntity> getMatches(@PathVariable Long id) {
        return matchService.getUserMatches(id);
    }

    @GetMapping("matched-users/{id}")
    public List<UserEntity> getMatchedUsers(@PathVariable Long id) {
        return matchService.getMatchedUsersByUserId(id);
    }

    @GetMapping("matched-users-and-contacts/{id}")
    public List<MatchDto> getMatchedUsersAndContacts(@PathVariable Long id) {
        return matchService.getMatchedUsersAndContactsByUserId(id);
    }

}
