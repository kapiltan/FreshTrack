package com.freshtrack.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.freshtrack.user.dto.CreateUserRequest;
import com.freshtrack.user.dto.UserResponse;
import com.freshtrack.user.mapper.UserMapper;
import com.freshtrack.user.model.User;
import com.freshtrack.user.repository.UserRepository;
import com.freshtrack.warehouse.repository.WarehouseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final WarehouseRepository warehouseRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse create(CreateUserRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("User with email " + request.getEmail() + " already exists.");
        }

        request.getWarehouseIds().forEach(warehouseId -> {
            if (!warehouseRepository.existsById(warehouseId)) {
                throw new RuntimeException("Warehouse with ID " + warehouseId + " does not exist.");
            }
        });

        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        user = userRepository.save(user);
        return UserMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with ID " + id + " not found."));
        return UserMapper.toResponse(user);
    }

    @Override
    public void deactivate(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with ID " + id + " not found."));
        user.setActive(false);
        userRepository.save(user);
    }
}
