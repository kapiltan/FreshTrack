package com.freshtrack.user.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.freshtrack.role.model.RoleType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private RoleType role;
    private List<String> warehouseIds;
    private boolean active;
}
