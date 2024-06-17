package com.example.dating_app.service.impl;

import com.example.dating_app.dto.TestDto;
import com.example.dating_app.entity.TestEntity;
import com.example.dating_app.exception.TestNotFoundException;
import com.example.dating_app.mapper.TestMapper;
import com.example.dating_app.repository.TestRepository;
import com.example.dating_app.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    private final TestMapper testMapper;

    @Override
    public TestDto findById(Long id) throws TestNotFoundException {
        Optional<TestEntity> byId = testRepository.findById(id);
        if (byId.isPresent())
            return testMapper.testEntityToTestDto(byId.get());
        else throw new TestNotFoundException("test not found");
    }
}
