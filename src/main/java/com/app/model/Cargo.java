package com.app.model;

import com.app.model.Enums.CargoStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "CARGO")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARGO")
    private int idCargo;

    @Positive(message = "Cargo number must have positive value.")
    @Column(name = "CARGO_NUMBER")
    private int cargoNumber;

    @Size(min = 2, max = 15, message = "Name must be between 2 and 15 characters.")
    @Column(name = "NAME")
    private String name;

    @Positive(message = "Weight must have positive value.")
    @Column(name = "WEIGHT")
    private int weight;

    @NotNull
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
                '}';
    }
}
