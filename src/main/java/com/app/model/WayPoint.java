package com.app.model;

import lombok.Data;

import javax.persistence.*;

@Embeddable
@Data
public class WayPoint {

    @Column(name = "CITY")
    private String city;

    @Column(name = "LATITUDE")
    private int latitude;

    @Column(name = "LONGITUDE")
    private int longitude;
}
