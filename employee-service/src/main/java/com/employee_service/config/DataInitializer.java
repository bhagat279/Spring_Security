package com.employee_service.config;

import com.employee_service.entity.AppUser;
import com.employee_service.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (appUserRepository.findByUsername("admin").isEmpty()) {

            AppUser admin = AppUser.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .role("ROLE_ADMIN")
                    .build();

            appUserRepository.save(admin);
        }

        if (appUserRepository.findByUsername("employee").isEmpty()) {

            AppUser employee = AppUser.builder()
                    .username("employee")
                    .password(passwordEncoder.encode("emp123"))
                    .role("ROLE_EMPLOYEE")
                    .build();

            appUserRepository.save(employee);
        }
    }
}