package com.ratify.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String jobTitle;
    private String imageUrl;
    private String status;
    private int dailyRate;
    private int daysWorkedAMonth;

    public Employee(String name, String email, String number, String role, String imageUrl, String status , int dailyRate, int daysWorkedAMonth ) {
        this.name = name;
        this.email = email;
        this.phone = number;
        this.jobTitle = role;
        this.imageUrl = imageUrl;
        this.status = status;
        this.dailyRate = dailyRate;
        this.daysWorkedAMonth = daysWorkedAMonth;

    }

    public Employee() {

    }

}



