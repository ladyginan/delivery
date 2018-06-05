package com.app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "USER_DRIVER")
public class UserDriver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER_DRIVER")
    private int idUserDriver;

    @Column(name = "ID_USER")
    private String idUser;

    @Column(name = "ID_DRIVER")
    private int idDriver;

    public UserDriver(String idUser, int idDriver) {
        this.idUser = idUser;
        this.idDriver = idDriver;
    }
}
