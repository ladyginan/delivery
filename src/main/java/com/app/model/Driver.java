package com.app.model;


import com.app.model.Enums.DriverStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "DRIVERS")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DRIVER", unique = true)
    private int idDriver;

    @Column(name = "PERSONAL_NUMBER")
    private int personalNumber;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @Column(name = "HOURS_WORKED")
    private int hoursWorked;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private DriverStatus status;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CITY")
    private Map city;


    @ManyToOne
    @JoinColumn(name = "ID_WAGGON")
    private Waggon waggon;

    @ManyToOne
    @JoinColumn(name = "ID_ORDER")
    private Order order;

    // variable for calculating hours worked
    @Column(name = "driverVariableTime")
    private int driverVariableTime;

    public Driver(int personalNumber, String name, String secondName, int hoursWorked, DriverStatus status, Map city, Waggon waggon) {
        this.personalNumber = personalNumber;
        this.name = name;
        this.secondName = secondName;
        this.hoursWorked = hoursWorked;
        this.status = status;
        this.city = city;
        this.waggon = waggon;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "idDriver=" + idDriver +
                ", personalNumber=" + personalNumber +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", status=" + status +
                '}';
    }
}

