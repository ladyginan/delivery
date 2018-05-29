package com.app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "AUTHORITIES")
public class Authorities {
    @Id
    @Column(name = "AUTHORITY")
    private String authority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERNAME")
    private User user;

    @Override
    public String toString() {
        return "Authorities{" +
                "authority='" + authority + '\'' +
                '}';
    }
}
