package com.app.model;

import com.app.model.Enums.OrderStatus;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ORDER",unique = true)
    private int idOrder;

    @Enumerated(EnumType.STRING)
    @Column(name ="ORDER_STATUS")
    private OrderStatus status;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<WayPoint> pointList;

    @OneToOne(mappedBy = "order", fetch = FetchType.EAGER)
    private Waggon currentWaggon;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Driver> DriverList;
}
