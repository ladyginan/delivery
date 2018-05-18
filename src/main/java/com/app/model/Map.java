package com.app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "MAP")
public class Map {
    @Id
    @GeneratedValue
    @Column(name = "ID_CITY", nullable = false)
    private int idCity;

    @Column(name = "CITY")
    private String city;

    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "LONGITUDE")
    private double longitude;

    @OneToOne(mappedBy = "map", fetch = FetchType.EAGER)
    private WayPoint wayPoint;

    public Map(String city, double latitude, double longitude){
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
