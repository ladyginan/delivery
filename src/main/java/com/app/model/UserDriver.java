package com.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "User_Driver")
public class UserDriver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserDriver;

    @Column
    private String idUser;

    @Column
    private int idDriver;

    public UserDriver(String idUser, int idDriver) {
        this.idUser = idUser;
        this.idDriver = idDriver;
    }
}
