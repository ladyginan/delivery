package com.app.model;

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

    @Column(name = "STATUS")
    private OrderStatus status;

    @OneToOne(mappedBy = "cargo", fetch = FetchType.EAGER)
    private WayPoint wayPoint;

}
