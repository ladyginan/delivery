package com.app.repository.api;

import java.util.List;

import com.app.model.Driver;

public interface DriversRepositoryInterface {

    Driver addDriver(Driver driver);
    void removeDriver(Driver driver);
    void updateDriver(Driver driver);
    List<Driver> getAllDrivers();

}