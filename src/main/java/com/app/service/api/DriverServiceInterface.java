package com.app.service.api;

import com.app.model.Driver;

import java.util.List;

public interface DriverServiceInterface {
    public List<Driver> getAllDrivers();

    /**
     *
     * @param driver
     */
    void addDriver(Driver driver);

    /**
     * method for remove id
     * @param id
     */
    void removeDriver(int id);

    void updateDriver(Driver driver);

    Driver getDriver(int id);


}
