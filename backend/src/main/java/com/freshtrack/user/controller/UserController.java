package com.freshtrack.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freshtrack.user.dto.CreateUserRequest;
import com.freshtrack.user.dto.UserResponse;
import com.freshtrack.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable String id) {
        return userService.getById(id);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateUser(@PathVariable String id) {
        userService.deactivate(id);
    }
}
