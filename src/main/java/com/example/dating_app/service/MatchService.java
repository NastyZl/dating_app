package com.example.dating_app.service;

import com.example.dating_app.dto.MatchDto;
import com.example.dating_app.entity.MatchEntity;
import com.example.dating_app.entity.UserEntity;

import java.util.List;

public interface MatchService {

    List<MatchDto> getUserMatches(String login);
}