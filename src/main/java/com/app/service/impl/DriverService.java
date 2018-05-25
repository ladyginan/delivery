package com.app.service.impl;

import com.app.model.Driver;
import com.app.repository.DriversRepositoryInterface;
import com.app.repository.WaggonRepositoryInterface;
import com.app.service.DriverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DriverService implements DriverServiceInterface {
    @Autowired
    private DriversRepositoryInterface driversRepository;
    @Autowired
    private WaggonRepositoryInterface waggonRepository;
    @Transactional
    public List<Driver> getAllDrivers() {
        return driversRepository.getAllDrivers();
    }
    @Transactional
    public void addDriver(Driver driver) {
        driversRepository.addDriver(driver);
    }
    @Transactional
    public void updateDriver(Driver driver) {
        driversRepository.updateDriver(driver);
    }
    @Transactional
    public Driver getDriver(int id) {
        return driversRepository.getDriver(id);
    }
    @Transactional
    public void removeDriver(int id) {
        driversRepository.removeDriver(id);
    }


}