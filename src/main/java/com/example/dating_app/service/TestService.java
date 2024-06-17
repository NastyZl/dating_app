package com.example.dating_app.service;

import com.example.dating_app.dto.TestDto;
import com.example.dating_app.exception.TestNotFoundException;

import java.util.Optional;

public interface TestService {
    TestDto findById(Long id) throws TestNotFoundException;
}
