package com.example.Testing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            Employee luis = new Employee(
                    "Luis",
                    "LuisGoate2@gmail.com",
                    "07841425022",
                    "Python Developer",
                    "https://bootdey.com/img/Content/avatar/avatar2.png"
            );

            Employee bob = new Employee(
                    "Bob",
                    "BobBrown@gmail.com",
                    "07841425023",
                    "Team Lead",
                    "https://bootdey.com/img/Content/avatar/avatar1.png");;

            repository.saveAll(
                    List.of(luis, bob)
            );
        };
    }
}
