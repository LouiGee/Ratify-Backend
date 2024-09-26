package com.example.testing22092024.Employee;

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

  //  private String hiringScore;
  //  private String iQTestScore;
  //  private String personalityTestScore;
  //  private String degreeScore;
   // private String commuteTime;
   // private String employeeSurveyScore;
   // private

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

    // Getters and setters

