package com.example.dating_app.mapper;

import com.example.dating_app.dto.UserDetailsDto;
import com.example.dating_app.entity.UserContactEntity;
import com.example.dating_app.entity.UserEntity;
import com.example.dating_app.entity.UserProfileEntity;
import com.example.dating_app.enums.ZodiacSign;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class UserContactMapper {
    public UserContactEntity mapUserDetailsDtoToUserContactEntity(UserDetailsDto userDetailsDto, UserEntity userEntity) {
        var userContactEntity = new UserContactEntity();
        userContactEntity.setUser(userEntity);
        userContactEntity.setTelegram(userDetailsDto.getTelegram());
        userContactEntity.setPhoneNumber(userDetailsDto.getPhoneNumber());
        return userContactEntity;
    }
}