package com.freshtrack.user.service;

import java.util.List;

import com.freshtrack.user.dto.CreateUserRequest;
import com.freshtrack.user.dto.UserResponse;

public interface UserService {
    UserResponse create(CreateUserRequest request);

    List<UserResponse> getAll();

    UserResponse getById(String id);

    void deactivate(String id);
}
