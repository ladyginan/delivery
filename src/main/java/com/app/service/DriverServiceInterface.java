package com.app.service;

import com.app.DTO.DriverDTO;
import com.app.model.Driver;

import java.util.List;

public interface DriverServiceInterface {
    List<Driver> getAllDrivers();

    /**
     * @param driver
     */
    void addDriver(Driver driver);

    /**
     * remove Driver by id
     *
     * @param id
     */
    void removeDriver(int id);

    /**
     * edit Driver
     *
     * @param driver
     */
    void updateDriver(Driver driver);

    /**
     * @param id
     * @return driverDTO
     */
    Driver getDriver(int id);


}
