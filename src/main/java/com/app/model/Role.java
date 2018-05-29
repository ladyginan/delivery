package com.app.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "ROLES")
public class Role {
    @Id
    @Column(name = "ROLE")
    private String role;

    @ManyToOne
    @JoinColumn(name = "USERNAME")
    private User user;
}
