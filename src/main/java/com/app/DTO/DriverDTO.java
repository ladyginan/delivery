package com.app.DTO;

import com.app.model.Driver;
import com.app.model.Enums.DriverStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DriverDTO {
    private int idDriver;
    private int personalNumber;
    private String name;
    private String secondName;
    private int hoursWorked;
    private DriverStatus status;
    private int mapId;
    private int waggon;
    private int idOrder;

    public DriverDTO(Driver driver) {
        this.idDriver = driver.getIdDriver();
        this.personalNumber = driver.getPersonalNumber();
        this.name = driver.getName();
        this.secondName = driver.getSecondName();
        this.hoursWorked = driver.getHoursWorked();
        this.status = driver.getStatus();
        this.mapId = driver.getCity().getIdCity();
        this.waggon = driver.getWaggon().getIdWaggon();
    }

    public DriverDTO(Driver driver, int idOrder) {
        this.idDriver = driver.getIdDriver();
        this.personalNumber = driver.getPersonalNumber();
        this.name = driver.getName();
        this.secondName = driver.getSecondName();
        this.hoursWorked = driver.getHoursWorked();
        this.status = driver.getStatus();
        this.mapId = driver.getCity().getIdCity();
        this.waggon = driver.getWaggon().getIdWaggon();
        this.idOrder = idOrder;
    }
}
