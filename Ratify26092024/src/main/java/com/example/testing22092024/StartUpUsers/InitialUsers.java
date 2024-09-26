package com.example.testing22092024.StartUpUsers;

import com.example.testing22092024.Auth.TwoFactorAuthenticationService;
import com.example.testing22092024.Domain.Role;
import com.example.testing22092024.Domain.User;
import com.example.testing22092024.Repository.RoleRepository;
import com.example.testing22092024.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


@Configuration
@RequiredArgsConstructor
public class InitialUsers {


    private final PasswordEncoder passwordEncoder;
    private final TwoFactorAuthenticationService twoFactorService;

   // @Bean
   // public CommandLineRunner runnerRole(RoleRepository roleRepository) {
   //     return args -> {

    //    };
    //}

    @Bean
    public CommandLineRunner runnerUser(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {

            roleRepository.save(Role.builder().name("USER").build());
            roleRepository.save(Role.builder().name("ADMIN").build());

            var userRoles = roleRepository.findByName("USER");
            var adminRoles = roleRepository.findByName("ADMIN");

            User testUser = new User(
                    "User",
                    "Test",
                    "RatifyTest@gmail.com",
                    passwordEncoder.encode("Test12345"),
                    true,
                    false,
                    List.of(userRoles),
                    "BBN22U6IM6Z5S52HEYKKI5ED4RHEB5H7",
                    twoFactorService.generateQrCodeImageUri("BBN22U6IM6Z5S52HEYKKI5ED4RHEB5H7")


            );

            User admin = new User(
                    "Admin",
                    "Admin",
                    "RatifyAdmin@gmail.com",
                    passwordEncoder.encode("Admin12345"),
                    true,
                    false,
                    List.of(adminRoles),
                    "YOCVJVUVMLK7Q46IDW6JKZWWKKWTVT53",
                    twoFactorService.generateQrCodeImageUri("YOCVJVUVMLK7Q46IDW6JKZWWKKWTVT53")

            );


            userRepository.saveAll(List.of(testUser, admin));



        };

    }
}
