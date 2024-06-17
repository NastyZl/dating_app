package com.example.dating_app.mapper;

import com.example.dating_app.dto.TestDto;
import com.example.dating_app.entity.TestEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestMapper {

    TestDto testEntityToTestDto(TestEntity testEntity);

}
