package com.app.model;

import com.app.model.Enums.OrderType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "WAY_POINTS")
@Data
public class WayPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_WAY_POINT", unique = true)
    private int idWayPoint;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_TYPE")
    private OrderType orderType;

    @OneToOne
    @JoinColumn(name = "ID_CITY")
    private Map city;

    @OneToOne
    @JoinColumn(name = "ID_CARGO")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "ID_ORDER")
    private Order order;
}
