package com.app.model;

import com.app.model.Enums.WaggonStatus;
import com.sun.xml.internal.ws.developer.UsesJAXBContext;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name ="WAGGONS")
@Data
public class Waggon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private String IdWaggon;

    @Column(name = "SHIFT_SIZE")
    private int shiftSize;

    @Column(name = "CAPACITY")
    private int capacity;

    @Column(name = "STATUS")
    private WaggonStatus status;

    @Column(name = "CURRENT_CITY")
    private String currentCity;

    @OneToOne
    @JoinColumn(name = "idDriver")
    private Driver driver;

    @OneToOne
    @JoinColumn(name = "idOrder")
    private Order order;

}
