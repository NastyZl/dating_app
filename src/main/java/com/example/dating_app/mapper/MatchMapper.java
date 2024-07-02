package com.example.dating_app.mapper;

import com.example.dating_app.dto.MatchDto;
import com.example.dating_app.entity.UserContactEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class MatchMapper {

    public MatchDto mapUserContactsEntityToMatchDto(UserContactEntity userContactEntity) {
        return new MatchDto(userContactEntity.getUser().getId(),
                            userContactEntity.getUser().getLogin(),
                            userContactEntity.getTelegram(),
                            userContactEntity.getPhoneNumber());
    }
}
