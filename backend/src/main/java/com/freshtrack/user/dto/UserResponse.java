package com.freshtrack.user.dto;

import java.util.List;

import com.freshtrack.role.model.RoleType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private RoleType role;
    private List<String> warehouseIds;
    private boolean active;
}
