package com.example.Testing.Role;

import com.example.Testing.User.User;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
    // getters and setters


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

   // public Set<User> getUsers() {
   //     return users;
    //}

    //public void setUsers(Set<User> users) {
    //    this.users = users;
    //}
}

