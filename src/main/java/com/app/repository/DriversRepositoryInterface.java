package com.app.repository;

import com.app.model.Driver;

import java.util.List;

public interface DriversRepositoryInterface {

    List<Driver> getAllDrivers();

    Driver addDriver(Driver driver);

    Driver removeDriver(int id);

    Driver updateDriver(Driver driver);

    Driver getDriver(int id);

    int getAllFreeDriversCount();

    int getAllBusyDriversCount();
}