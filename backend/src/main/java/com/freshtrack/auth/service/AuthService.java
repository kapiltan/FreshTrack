package com.freshtrack.auth.service;

import com.freshtrack.auth.dto.LoginRequest;
import com.freshtrack.auth.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
