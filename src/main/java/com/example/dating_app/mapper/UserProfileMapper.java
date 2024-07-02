package com.example.dating_app.mapper;

import com.example.dating_app.dto.UserDetailsDto;
import com.example.dating_app.entity.UserEntity;
import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.dto.UserProfileDto;
import com.example.dating_app.enums.ZodiacSign;
import org.mapstruct.Mapper;

import java.util.stream.Stream;

@Mapper(componentModel = "spring")
public class UserProfileMapper {
    public UserProfileEntity mapUserDetailsDtoToUserProfileEntity(UserDetailsDto userDetailsDto, UserEntity userEntity) {
        var userProfileEntity = new UserProfileEntity();
        userProfileEntity.setUserId(userEntity);
        userProfileEntity.setName(userDetailsDto.getName());
        userProfileEntity.setAge(userDetailsDto.getAge());
        userProfileEntity.setPhoto(userDetailsDto.getPhotoUrl());
        userProfileEntity.setCity(userDetailsDto.getCity());
        userProfileEntity.setHeight(userDetailsDto.getHeight());
        userProfileEntity.setDescription(userDetailsDto.getDescription());
        userProfileEntity.setZodiacSign(ZodiacSign.valueOf(userDetailsDto.getZodiacSign()));
        return userProfileEntity;
    }

    public UserProfileDto mapUserProfileEntityToUserProfileDto(UserProfileEntity userProfileEntity) {
        var userProfileDto = new UserProfileDto();
        userProfileDto.setUserId(userProfileEntity.getUserId().getId());
        userProfileDto.setName(userProfileEntity.getName());
        userProfileDto.setAge(userProfileEntity.getAge());
        userProfileDto.setPhoto(userProfileEntity.getPhoto());
        userProfileDto.setCity(userProfileEntity.getCity());
        userProfileDto.setHeight(userProfileEntity.getHeight());
        userProfileDto.setDescription(userProfileEntity.getDescription());
        userProfileDto.setZodiacSign(userProfileEntity.getZodiacSign());
        return userProfileDto;
    }
}
