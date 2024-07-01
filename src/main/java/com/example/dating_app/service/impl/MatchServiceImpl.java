package com.example.dating_app.service.impl;

import com.example.dating_app.dto.MatchDto;
import com.example.dating_app.entity.MatchEntity;
import com.example.dating_app.entity.UserEntity;
import com.example.dating_app.repository.MatchRepository;
import com.example.dating_app.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    @Override
    public List<MatchEntity> getUserMatches(long id) {
        var matches = matchRepository.findMatchesByUserId(id);

        if (matches.isEmpty()) {
            return null;
        }

        return matches;
    }

    public List<UserEntity> getMatchedUsersByUserId(long id) {
        var matches = matchRepository.findMatchesByUserId(id);

        if (matches.isEmpty()) {
            return null;
        }

        List<UserEntity> matchedUsers = new ArrayList<>();

        for (MatchEntity match : matches) {
            if (match.getFirstUserId().getId() == id) {
                matchedUsers.add(match.getSecondUserId());
            }
            else {
                matchedUsers.add(match.getFirstUserId());
            }
        }

        return matchedUsers;
    }
}
