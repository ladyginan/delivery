package com.app.model;


import com.app.model.Enums.DriverStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "DRIVERS", uniqueConstraints = {@UniqueConstraint(columnNames = "PERSONAL_NUMBER")})
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DRIVER", unique = true)
    private int idDriver;

    @Positive(message = "Personal number must have positive value.")
    @Column(name = "PERSONAL_NUMBER")
    private int personalNumber;

    @Size(min = 2, max = 15, message = "Name must be between 2 and 15 characters.")
    @Column(name = "NAME")
    private String name;

    @Size(min = 2, max = 15, message = "Second name must be between 2 and 15 characters.")
    @Column(name = "SECOND_NAME")
    private String secondName;

    @PositiveOrZero(message = "Hour's field must have positive value.")
    @Column(name = "HOURS_WORKED")
    private int hoursWorked;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private DriverStatus status;

    @NotNull
    @ManyToOne
//            (cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CITY")
    private Map city;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_WAGGON")
    private Waggon waggon;

    @ManyToOne
    @JoinColumn(name = "ID_ORDER")
    private Order order;

    // variable for calculating hours worked
    @Column(name = "DRIVER_VARIABLE_TIME")
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

