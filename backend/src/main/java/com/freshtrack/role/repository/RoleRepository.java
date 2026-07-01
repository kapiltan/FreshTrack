package com.freshtrack.role.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.freshtrack.role.model.Role;
import com.freshtrack.role.model.RoleType;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(RoleType name);
}
