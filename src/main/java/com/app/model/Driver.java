package com.app.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DRIVERS")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_DRIVER", unique = true)
    private int idDriver;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @Column(name = "HOURS_WORKED")
    private int hoursWorked;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CURRENT_CITY")
    private String currentCity;

    @Column(name = "CURRENT_WAGGON")
    private String currentWaggon;

}