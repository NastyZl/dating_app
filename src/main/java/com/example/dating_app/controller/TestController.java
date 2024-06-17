package com.example.dating_app.controller;

import com.example.dating_app.dto.TestDto;
import com.example.dating_app.exception.TestNotFoundException;
import com.example.dating_app.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1.0/dating")
public class TestController {

    private final TestService testService;

    @GetMapping(value = "/{testId}")
    public String findById(@PathVariable Long testId) throws TestNotFoundException {
        TestDto byId = testService.findById(testId);
        return byId.getValue();
    }

    @GetMapping(value = "/test")
    public String findById() {
        return "top";
    }
}
