package com.app.service.api;

import com.app.model.Driver;

import java.util.List;

public interface DriverServiceInterface {
    public List<Driver> getAllDrivers();

    void addDriver(Driver driver);

    void removeDriver(int id);

    void updateDriver(Driver driver);

    Driver getDriver(int id);


}
