package com.example.dating_app.service;

import com.example.dating_app.dto.AuthenticationRequest;
import com.example.dating_app.dto.AuthenticationResponse;
import com.example.dating_app.dto.RegisterRequest;


public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
