package com.app.model;

import com.app.model.Enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ORDER", unique = true)
    private int idOrder;

    @Column(name = "REGISTRATION_NUMBER_ORDER")
    private int regNumberOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    private List<WayPoint> pointList;

    @OneToOne
    @JoinColumn(name = "WAGGONS")
    private Waggon currentWaggon;

    @OneToMany(mappedBy = "order")
    private List<Driver> drivers;
}
