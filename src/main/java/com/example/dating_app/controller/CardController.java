package com.example.dating_app.controller;

import com.example.dating_app.dto.UserProfilesDto;
import com.example.dating_app.entity.LikesEntity;
import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nextcard")
public class CardController {
    private final CardService cardService;

    @GetMapping(value = "/dislike")
    public UserProfileEntity dislikeNextCard(@RequestBody UserProfileEntity userProfileEntity) {
        return cardService.dislikeNextCard(userProfileEntity);
    }

}
