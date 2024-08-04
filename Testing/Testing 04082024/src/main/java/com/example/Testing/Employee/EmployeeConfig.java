package com.example.Testing.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            Employee clive = new Employee(
                    "Clive",
                    "CliveSmith2@gmail.com",
                    "07841600700",
                    "Python Developer",
                    "https://bootdey.com/img/Content/avatar/avatar2.png",
                    "Active"
            );

            Employee bob = new Employee(
                    "Bob",
                    "BobBrown@gmail.com",
                    "07841425023",
                    "Team Lead",
                    "https://bootdey.com/img/Content/avatar/avatar1.png",
                    "Active");

            Employee sarah = new Employee(
                    "Sarah",
                    "SarahJones@hotmail.com",
                    "07842621329",
                    "Java Developer",
                    "https://bootdey.com/img/Content/avatar/avatar3.png"
                    ,"On-Boarding");

            Employee jenny = new Employee(
                    "Jenny",
                    "Jenny Howard@hotmail.com",
                    "07842621329",
                    "Front-End Developer",
                    "https://bootdey.com/img/Content/avatar/avatar8.png",
                    "Off-Boarding");

            repository.saveAll(
                    List.of(clive, bob, sarah, jenny)
            );
        };
    }
}
