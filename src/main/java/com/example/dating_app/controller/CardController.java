package com.example.dating_app.controller;

import com.example.dating_app.dto.UserProfilesDto;
import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nextcard")
public class CardController {
    private final CardService cardService;

    @GetMapping(value = "/dislike")
    public UserProfilesDto dislikeNextCard(Principal principal) {
        return cardService.dislikeNextCard(principal);
    }

    @GetMapping(value = "/like")
    public UserProfilesDto likeNextCard(@RequestBody UserProfileEntity likedUserProfileEntity, Principal principal) {
        return cardService.likeNextCard(likedUserProfileEntity, principal);
    }

}
