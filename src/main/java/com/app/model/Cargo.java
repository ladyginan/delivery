package com.app.model;

import com.app.model.Enums.CargoStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CARGO")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CARGO")
    private int idCargo;

    @Column(name = "CARGO_NUMBER")
    private int cargoNumber;

    @Column(name = "NAME")
    private String name;

    @Column(name = "WEIGHT")
    private int weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private CargoStatus status;

    @OneToOne(mappedBy = "cargo")
    private WayPoint wayPoint;

}
