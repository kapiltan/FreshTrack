package com.freshtrack.common.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.freshtrack.role.model.Role;
import com.freshtrack.role.model.RoleType;
import com.freshtrack.role.repository.RoleRepository;
import com.freshtrack.user.model.User;
import com.freshtrack.user.repository.UserRepository;
import com.freshtrack.warehouse.model.Warehouse;
import com.freshtrack.warehouse.repository.WarehouseRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final WarehouseRepository wareHouseRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByName(RoleType.ADMIN).isEmpty()) {
            roleRepository.save(Role.builder().name(RoleType.ADMIN).build());
        }

        if (roleRepository.findByName(RoleType.HUB_USER).isEmpty()) {
            roleRepository.save(Role.builder().name(RoleType.HUB_USER).build());
        }

        if (wareHouseRepository.findByWarehouseCode("WH001").isEmpty()) {
            wareHouseRepository
                    .save(Warehouse.builder().warehouseCode("WH001").warehouseName("Pune Warehouse").city("Pune")
                            .active(true).build());
        }

        if (wareHouseRepository.findByWarehouseCode("WH002").isEmpty()) {
            wareHouseRepository
                    .save(Warehouse.builder().warehouseCode("WH002").warehouseName("Delhi Warehouse").city("Delhi")
                            .active(true).build());
        }
        if (userRepository.findByEmail("admin@freshtrack.com").isEmpty()) {
            userRepository.save(User.builder()
                    .firstname("System")
                    .lastname("Admin")
                    .email("admin@freshtrack.com")
                    .password(passwordEncoder.encode("admin123"))
                    .role(RoleType.ADMIN)
                    .warehouseIds(List.of())
                    .active(true)
                    .build());
        }
    }

}
