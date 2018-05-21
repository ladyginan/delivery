package com.app.model;

import com.app.model.Enums.WaggonStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "WAGGONS")
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

    @OneToOne(mappedBy = "waggon")
    private Driver driver;

    @OneToOne(mappedBy = "currentWaggon")
    private Order order;

}
