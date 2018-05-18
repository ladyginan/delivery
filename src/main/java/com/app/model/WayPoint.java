package com.app.model;

import com.app.model.Enums.OrderType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class WayPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="ID_WAY_POINT", unique = true)
    private int idWayPoint;

    @OneToOne
    @JoinColumn(name = "ID_CITY")
    private Map map;

    @OneToOne
    @JoinColumn(name = "ID_CARGO")
    private Cargo cargo;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_TYPE")
    private OrderType orderType;

    @ManyToOne
    @JoinColumn(name = "ID_ORDER")
    private Order order;


}
