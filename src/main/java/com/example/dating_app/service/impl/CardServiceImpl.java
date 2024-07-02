package com.example.dating_app.service.impl;

import com.example.dating_app.dto.UserProfilesDto;
import com.example.dating_app.entity.LikesEntity;
import com.example.dating_app.entity.MatchEntity;
import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.mapper.UserProfileMapper;
import com.example.dating_app.repository.LikesRepository;
import com.example.dating_app.repository.MatchRepository;
import com.example.dating_app.repository.UserProfileRepository;
import com.example.dating_app.repository.UserRepository;
import com.example.dating_app.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final UserProfileRepository userProfileRepository;
    private final LikesRepository likesRepository;
    private final MatchRepository matchRepository;
    private final UserProfileMapper userProfileMapper;
    private final UserRepository userRepository;

    @Override
    public UserProfilesDto dislikeNextCard(Principal principal) {
        Long userId = userProfileRepository.findUserProfileIdByLogin(principal.getName());
        UserProfileEntity userProfileEntity = userProfileRepository.findById(userId).get();
        Long id = findCorrectUserId(userProfileEntity);
        Optional<UserProfileEntity> userProfile = userProfileRepository.findById(id);
        UserProfilesDto userProfilesDto = userProfileMapper.userEntityToUserDto(userProfile.get());
        userProfilesDto.setUserId(null);
        return userProfilesDto;
    }

    @Override
    public UserProfilesDto likeNextCard(UserProfileEntity likedUserProfileEntity, Principal principal) {

        if (likesRepository.checkIfUserIdExistsInLikedUserIdWithUser(userRepository.findByLogin(principal.getName()).get().getId(), likedUserProfileEntity.getUserId().getId())) {
            likesRepository.deleteLike(userRepository.findById(likedUserProfileEntity.getUserId().getId()).get().getId(), userRepository.findByLogin(principal.getName()).get().getId());
            likesRepository.deleteLike(userRepository.findByLogin(principal.getName()).get().getId(), userRepository.findById(likedUserProfileEntity.getUserId().getId()).get().getId());
            createMatch(likedUserProfileEntity, principal.getName());
        }
        else {
            createLike(likedUserProfileEntity, principal.getName());
        }



        Long userId = userProfileRepository.findUserProfileIdByLogin(principal.getName());
        UserProfileEntity userProfileEntity = userProfileRepository.findById(userId).get();

        Long id = findCorrectUserId(userProfileEntity);
        Optional<UserProfileEntity> userProfile = userProfileRepository.findById(id);
        UserProfilesDto userProfilesDto = userProfileMapper.userEntityToUserDto(userProfile.get());
        userProfilesDto.setUserId(null);

        return userProfilesDto;
    }

    @Override
    public void createLike(UserProfileEntity userProfileEntity, String login) {
        Long id = userProfileEntity.getUserId().getId();
        LikesEntity like = new LikesEntity();
        like.setUserId(userRepository.findByLogin(login).get());
        like.setLikedUserId(userRepository.findById(id).get());


        likesRepository.save(like);
    }


    @Override
    public void createMatch(UserProfileEntity userProfileEntity, String login) {
        Long id = userProfileEntity.getUserId().getId();
        MatchEntity match = new MatchEntity();
        match.setFirstUserId(userRepository.findByLogin(login).get());
        match.setSecondUserId(userRepository.findById(id).get());
        matchRepository.save(match);
    }


    private Long findCorrectUserId(UserProfileEntity userProfileEntity) {
        Long idMaxValue = userProfileRepository.getMaxUserId();
        Long currentUserId = userProfileEntity.getId();
        Long randomUserId = randomUserId(idMaxValue);
        while (isRandomUserIdNotCorrect(randomUserId, currentUserId)) {
            randomUserId = randomUserId(idMaxValue);
        }
        return randomUserId;
    }

    private Long randomUserId(Long idMaxValue) {
        Random random = new Random();
        return random.nextLong((idMaxValue - 1) + 1) + 1;
    }

    private boolean isRandomUserIdNotCorrect(Long randomUserId, Long currentUserId) {
        return randomUserId.equals(currentUserId);
    }
}
