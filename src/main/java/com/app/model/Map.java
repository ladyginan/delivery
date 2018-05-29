package com.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MAPS")
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CITY", nullable = false)
    private int idCity;

    @Column(name = "CITY")
    private String city;
    @JsonIgnore
    @Column(name = "LATITUDE")
    private Double latitude;
    @JsonIgnore
    @Column(name = "LONGITUDE")
    private Double longitude;

}
