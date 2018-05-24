package com.app.model;

import com.app.model.Enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "ORDERS")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_ORDER", unique = true)
    private int idOrder;

    @Column(name = "REGISTRATION_NUMBER_ORDER")
    private int regNumberOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<WayPoint> pointList;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "WAGGONS", referencedColumnName = "ID_WAGGON")
    private Waggon currentWaggon;

    @OneToMany(mappedBy = "order")
    private List<Driver> drivers;

    public Order(int regNumberOrder, OrderStatus status, List<WayPoint> pointList, Waggon currentWaggon, List<Driver> drivers) {
        this.regNumberOrder = regNumberOrder;
        this.status = status;
        this.pointList = pointList;
        this.currentWaggon = currentWaggon;
        this.drivers = drivers;
    }
}
