package com.example.dating_app.controller;

import com.example.dating_app.dto.MatchDto;
import com.example.dating_app.entity.MatchEntity;
import com.example.dating_app.entity.UserEntity;
import com.example.dating_app.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    @GetMapping()
    public List<MatchDto> getMatches(Principal principal) {
        return matchService.getUserMatches(principal.getName());
    }
}