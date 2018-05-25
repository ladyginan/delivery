package com.app.model;

import com.app.model.Enums.CargoStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "CARGO")
public class Cargo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @JsonIgnore
    @OneToMany(mappedBy = "cargo")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<WayPoint> wayPoints;

    @Override
    public String toString() {
        return "Cargo{" +
                "idCargo=" + idCargo +
                ", cargoNumber=" + cargoNumber +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", status=" + status +
                ", wayPoints=" + wayPoints +
                '}';
    }
}
