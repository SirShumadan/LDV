package com.example.ldv.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable=false, updatable = false)
    private Long id; //user_id <- Column.name ?

    @Column(name = "email", unique = true, nullable = false)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name="password", nullable=false)
    @NotBlank
    @Size(min=5, max=100)
    private String password;


    @Column(name="role")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String email, String password, Collection<Role> roles) {
        this(null, email, password, roles);
    }

    public User(Long id, String email, String password, Collection<Role> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles.isEmpty() ? Collections.EMPTY_SET : EnumSet.copyOf(roles);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
