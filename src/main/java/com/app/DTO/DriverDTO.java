package com.app.DTO;
import com.app.model.Enums.DriverStatus;
import com.app.model.Waggon;
import lombok.Data;

@Data
public class DriverDTO {
    private String name;
    private String secondName;
    private int hoursWorked;
    private DriverStatus status;
    private String currentCity;
    private Waggon currentWaggon;
}
