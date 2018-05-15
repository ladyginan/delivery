package com.app.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="WAY_POINT")
public class WayPoint {

    @Column(name = "CITY")
    private String city;

    @Id
    @Column(name = "distance")
    private int distance;
}
