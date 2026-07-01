package com.freshtrack.user.mapper;

import com.freshtrack.user.dto.UserResponse;
import com.freshtrack.user.model.User;

public class UserMapper {
    public static UserResponse toResponse(User user) {
        UserResponse userResponse = UserResponse.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
        return userResponse;
    }
}
