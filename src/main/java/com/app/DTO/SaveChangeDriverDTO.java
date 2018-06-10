package com.app.DTO;

import com.app.model.Enums.CargoStatus;
import com.app.model.Enums.DriverStatus;
import lombok.Data;

@Data
public class SaveChangeDriverDTO {
    private int idDriver;
    private CargoStatus orderCargoStatus;
    private DriverStatus driverStatus;
}