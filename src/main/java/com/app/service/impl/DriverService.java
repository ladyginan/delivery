package com.app.service.impl;

import com.app.DTO.DriverDTO;
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
//        Driver driver = driversRepository.getDriver(id);
//        driverDTO.setIdDriver(driver.getIdDriver());
//        driverDTO.setPersonalNumber(driver.getPersonalNumber());
//        driverDTO.setName(driver.getName());
//        driverDTO.setSecondName(driver.getSecondName());
//        driverDTO.setHoursWorked(driver.getHoursWorked());
//        driverDTO.setStatus(driver.getStatus());
//        driverDTO.setCity(driver.getCity());
//        driverDTO.setWaggon(driver.getWaggon());
        return driversRepository.getDriver(id);
    }

    @Transactional
    public void removeDriver(int id) {
        driversRepository.removeDriver(id);
    }


}