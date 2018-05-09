package com.app.service.impl;

import com.app.model.Driver;
import com.app.repository.impl.DriversRepository;
import com.app.service.api.DriverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService implements DriverServiceInterface {
    @Autowired
    private DriverServiceInterface driversRepository;

    public List<Driver> getAllDrivers() {
        return driversRepository.getAllDrivers();
    }

    public void addDriver(Driver driver){
        driversRepository.addDriver(driver);
    }

    public void updateDriver(Driver driver){
        driversRepository.updateDriver(driver);
    }

    public Driver getDriver(int id) {
        return driversRepository.getDriver(id);
    }


    public void removeDriver(int id){
        driversRepository.removeDriver(id);
    }


}