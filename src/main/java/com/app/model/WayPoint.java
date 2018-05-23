package com.app.model;

import com.app.model.Enums.OrderType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "WAY_POINTS")
@Data
public class WayPoint {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_WAY_POINT", unique = true)
    private int idWayPoint;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_TYPE")
    private OrderType orderType;

    @OneToOne
    @JoinColumn(name = "ID_CITY")
    private Map city;

    @ManyToOne
    @JoinColumn(name = "ID_CARGO")
    private Cargo cargo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_ORDER")
    private Order order;
}
