package com.app.model;

import com.app.model.Enums.WaggonStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "WAGGONS")
public class Waggon {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_WAGGON", unique = true)
    private int idWaggon;

    @Column(name = "REGISTRATION_NUMBER")
    private String regNumber;

    @Column(name = "SHIFT_SIZE")
    private int shiftSize;

    @Column(name = "CAPACITY")
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private WaggonStatus status;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "ID_CITY")
    private Map city;

    @JsonIgnore
    @OneToMany
    private List<Driver> drivers;

    @JsonIgnore
    @OneToOne(mappedBy = "currentWaggon", cascade = {CascadeType.ALL})
    private Order order;

}
