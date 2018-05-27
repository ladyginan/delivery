package com.app.repository;

import com.app.model.Driver;

import java.util.List;

public interface DriversRepositoryInterface {

    List<Driver> getAllDrivers();

    void addDriver(Driver driver);

    void removeDriver(int id);

    Driver updateDriver(Driver driver);

    Driver getDriver(int id);
}