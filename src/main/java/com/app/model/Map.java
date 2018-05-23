package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MAPS")
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CITY", nullable = false)
    private int idCity;

    @Column(name = "CITY")
    private String city;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @OneToOne(mappedBy = "city")
    private WayPoint wayPoint;

    @OneToOne(mappedBy = "city")
    private Driver driver;

    @OneToOne(mappedBy = "city")
    private Waggon waggon;

}
