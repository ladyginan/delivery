package com.app.DTO;

import com.app.model.Enums.DriverStatus;
import com.app.model.Map;
import com.app.model.Waggon;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DriverDTO {
    private int idDriver;
    private int personalNumber;
    private String name;
    private String secondName;
    private int hoursWorked;
    private DriverStatus status;
    private Map city;
    private Waggon waggon;

    public DriverDTO(){

    }
}
