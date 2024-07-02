package com.example.dating_app.service.impl;

import com.example.dating_app.dto.MatchDto;
import com.example.dating_app.entity.MatchEntity;
import com.example.dating_app.entity.UserEntity;
import com.example.dating_app.mapper.MatchMapper;
import com.example.dating_app.repository.MatchRepository;
import com.example.dating_app.repository.UserContactRepository;
import com.example.dating_app.repository.UserRepository;
import com.example.dating_app.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final UserRepository userRepository;
    private final UserContactRepository userContactRepository;
    private final MatchMapper matchMapper;

    @Override
    public List<MatchDto> getUserMatches(String login) {

        var user = userRepository.findByLogin(login);
        var id = user.get().getId();

        var matches = matchRepository.findMatchesByUserId(id);

        if (matches.isEmpty()) {
            return null;
        }

        List<MatchDto> matchedUsers = new ArrayList<>();

        for (MatchEntity match : matches) {
            if (match.getFirstUser().getId() == id) {
                matchedUsers.add(matchMapper.mapUserContactsEntityToMatchDto(
                                userContactRepository.findContactByUserId(match.getSecondUser().getId())));
            }
            else {
                matchedUsers.add(matchMapper.mapUserContactsEntityToMatchDto(
                                userContactRepository.findContactByUserId(match.getFirstUser().getId())));

            }
        }

        return matchedUsers;
    }
}



