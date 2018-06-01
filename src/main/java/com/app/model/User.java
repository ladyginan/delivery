package com.app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Authorities> authorities = new HashSet<>();

    //Getter and Setter methods

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}