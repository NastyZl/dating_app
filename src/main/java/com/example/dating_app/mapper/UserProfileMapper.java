package com.example.dating_app.mapper;

import com.example.dating_app.dto.UserProfilesDto;
import com.example.dating_app.entity.UserProfileEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfilesDto userEntityToUserDto(UserProfileEntity userEntity);
}