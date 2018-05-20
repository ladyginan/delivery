package com.app.model;

import com.app.model.Enums.WaggonStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "WAGGONS")
@Getter
@Setter
@NoArgsConstructor
public class Waggon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_WAGGON", unique = true)
    private int idWaggon;

    @Column(name = "REGISTRASION_NUMBER")
    private String regNumber;

    @Column(name = "SHIFT_SIZE")
    private int shiftSize;

    @Column(name = "CAPACITY")
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private WaggonStatus status;

    @OneToOne
    @JoinColumn(name = "ID_CITY")
    private Map city;

    @OneToOne
    @JoinColumn(name = "ID_DRIVER")
    private Driver driver;

    @OneToOne
    @JoinColumn(name = "ID_ORDER")
    private Order order;

}
