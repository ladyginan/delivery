package com.app.model;

import com.app.model.Enums.OrderStatus;
import lombok.Data;
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

    @Column(name ="ORDER_STATUS")
    private OrderStatus status;

    @Embedded
    private List<WayPoint> pointList;

    @OneToOne(mappedBy = "ORDER", fetch = FetchType.EAGER)
    private Waggon currentWaggon;

    @OneToMany(mappedBy = "ORDER", fetch = FetchType.EAGER)
    private List<Driver> DriverList;
}
