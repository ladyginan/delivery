package com.app.model;

import com.app.model.Enums.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "ORDERS")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ORDER", unique = true)
    private int idOrder;

    @Column(name = "REGISTRATION_NUMBER_ORDER")
    private int regNumberOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    private OrderStatus status;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<WayPoint> pointList;

    @OneToOne
//            (cascade = {CascadeType.ALL})
    @JoinColumn(name = "WAGGONS", referencedColumnName = "ID_WAGGON")
    private Waggon currentWaggon;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<Driver> drivers;

    public Order(int regNumberOrder, OrderStatus status, Waggon currentWaggon) {
        this.regNumberOrder = regNumberOrder;
        this.status = status;
        this.currentWaggon = currentWaggon;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", regNumberOrder=" + regNumberOrder +
                ", status=" + status +
                ", pointList=" + pointList +
                ", currentWaggon=" + currentWaggon +
                ", drivers=" + drivers +
                '}';
    }
}
