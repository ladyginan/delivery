package com.app.model;

import com.app.model.Enums.CargoStatus;
import com.app.model.Enums.OrderStatus;
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

    @Column(name = "NAME")
    private String name;

    @Column(name ="WEIGHT")
    private int weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private CargoStatus status;

    @OneToOne(mappedBy = "cargo", fetch = FetchType.EAGER)
    private WayPoint wayPoint;

}
