package com.freshtrack.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.freshtrack.auth.dto.LoginRequest;
import com.freshtrack.auth.dto.LoginResponse;
import com.freshtrack.security.JwtTokenProvider;
import com.freshtrack.user.model.User;
import com.freshtrack.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword());

        System.out.println("Matches = " + matches);

        if (!matches) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtTokenProvider.generateToken(user.getEmail());
        return new LoginResponse(token);
    }
}
