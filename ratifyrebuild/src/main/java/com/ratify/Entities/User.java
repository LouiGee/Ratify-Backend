package com.ratify.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_users")
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails, Principal {


    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;

    private boolean enabled;

    private boolean accountLocked;

    @Column( length = 500)
    private String secret;

    private boolean mfaEnabled;

    @Column( length = 50000)
    private String QRCodeURI;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime lastModifiedDate;

    public User( String firstname, String lastName, String email, String password, boolean isEnabled, boolean isAccountLocked, List<Role> roles, String secret, String QRCodeURI) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.enabled = isEnabled;
        this.accountLocked = isAccountLocked;
        this.roles = roles;
        this.secret = secret;
        this.QRCodeURI = QRCodeURI;

    }

    @Override
    public String getName() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
