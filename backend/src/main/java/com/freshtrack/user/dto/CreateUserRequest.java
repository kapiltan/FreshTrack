package com.freshtrack.user.dto;

import java.util.List;

import com.freshtrack.role.model.RoleType;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private RoleType role;
    private List<String> warehouseIds;
}
