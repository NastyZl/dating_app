package com.example.dating_app.service;

import com.example.dating_app.dto.MatchDto;

import java.util.List;

public interface MatchService {

    List<MatchDto> getUserMatches(String login);
}