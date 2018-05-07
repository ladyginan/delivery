package com.app.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DRIVERS")
public class Driver {

    @Column(name = "NAME")
    private String name;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @Id
    @Column(name = "ID_DRIVER", unique = true)
    private int idDriver;

    @Column(name = "HOURS_WORKED")
    private int hoursWorked;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CURRENT_CITY")
    private String currentCity;

    @Column(name = "CURRENT_WAGGON")
    private String currentWaggon;


}