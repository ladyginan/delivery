package com.app.model;

import com.app.model.Enums.WaggonStatus;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name ="WAGGONS")
@Getter
@Setter
@NoArgsConstructor
public class Waggon {
    @Id
    @Column
    private String idWaggon ;

    @Column(name = "SHIFT_SIZE")
    private int shiftSize;

    @Column(name = "CAPACITY")
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private WaggonStatus status;

    @Column(name = "CURRENT_CITY")
    private String currentCity;

    @OneToOne
    @JoinColumn(name = "ID_DRIVER")
    private Driver driver;

    @OneToOne
    @JoinColumn(name = "ID_ORDER")
    private Order order;

    public Waggon(int shiftSize, int capacity, WaggonStatus status, String currentCity, Driver driver, Order order){
        int id = (int)(Math.random()*100000);
        this.idWaggon = "UU" + id;
        this.shiftSize = shiftSize;
        this.capacity = capacity;
        this.status = status;
        this.currentCity = currentCity;
        this.driver = driver;
        this.order = order;
    }

}
