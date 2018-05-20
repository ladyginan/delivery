package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MAPS")
@AllArgsConstructor
@NoArgsConstructor
public class Map {
    @Id
    @GeneratedValue
    @Column(name = "ID_CITY", nullable = false)
    private int idCity;

    @Column(name = "CITY")
    private String city;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @OneToOne(mappedBy = "map")
    private WayPoint wayPoint;

    @OneToOne(mappedBy = "map")
    private Driver driver;

    @OneToOne(mappedBy = "map")
    private Waggon waggon;


}
