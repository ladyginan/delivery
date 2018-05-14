package com.app.model;


import com.app.model.Enums.DriverStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
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
    private DriverStatus status;

    @Column(name = "CURRENT_CITY")
    private String currentCity;

    @OneToOne(mappedBy = "driver", fetch = FetchType.EAGER)
    private Waggon currentWaggon;

}