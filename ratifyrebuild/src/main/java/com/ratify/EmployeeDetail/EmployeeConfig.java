package com.ratify.EmployeeDetail;

import com.ratify.Entities.Employee;
import com.ratify.Repository.EmployeeRepository;
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
                    "Active",
                    28,
                    20

            );

            Employee bob = new Employee(
                    "Bob",
                    "BobBrown@gmail.com",
                    "07841425023",
                    "Team Lead",
                    "https://bootdey.com/img/Content/avatar/avatar1.png",
                    "Active",
                    40,
                    20

            );

            Employee sarah = new Employee(
                    "Sarah",
                    "SarahJones@hotmail.com",
                    "07842621329",
                    "Java Developer",
                    "https://bootdey.com/img/Content/avatar/avatar3.png"
                    ,"On-Boarding"
                    ,28
                    ,20
            );

            Employee jenny = new Employee(
                    "Jenny",
                    "Jenny Howard@hotmail.com",
                    "07842621329",
                    "Front-End Developer",
                    "https://bootdey.com/img/Content/avatar/avatar8.png",
                    "Off-Boarding"
                    ,28
                    ,20

            );

            repository.saveAll(
                    List.of(clive, bob, sarah, jenny)
            );
        };
    }
}
