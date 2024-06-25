package com.example.dating_app.mapper;

import com.example.dating_app.dto.UserDto;
import com.example.dating_app.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userEntityToUserDto(UserEntity userEntity);

}
