package com.app.model;


import com.app.model.Enums.DriverStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "DRIVERS")
public class Driver {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CITY")
    private Map city;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_WAGGON")
    private Waggon waggon;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_ORDER")
    private Order order;

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