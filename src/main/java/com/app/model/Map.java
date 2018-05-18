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
    private int latitude;

    @Column(name = "LONGITUDE")
    private int longitude;

    @OneToOne(mappedBy = "map", fetch = FetchType.EAGER)
    private WayPoint wayPoint;



}
