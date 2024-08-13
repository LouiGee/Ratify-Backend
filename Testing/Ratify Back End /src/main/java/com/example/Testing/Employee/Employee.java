package com.example.Testing.Employee;

import jakarta.persistence.*;

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
  //  private String hiringScore;
  //  private String iQTestScore;
  //  private String personalityTestScore;
  //  private String degreeScore;
   // private String commuteTime;
   // private String employeeSurveyScore;
   // private

    public Employee(String name, String email, String number, String role, String imageUrl, String status) {
        this.name = name;
        this.email = email;
        this.phone = number;
        this.jobTitle = role;
        this.imageUrl = imageUrl;
        this.status = status;

    }

    public Employee() {

    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getPhone() {
        return phone;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

    // Getters and setters

