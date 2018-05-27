package com.app.service.impl;

import com.app.DTO.DriverDTO;
import com.app.model.Driver;
import com.app.model.Map;
import com.app.model.Waggon;
import com.app.repository.DriversRepositoryInterface;
import com.app.repository.MapRepositoryInterface;
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
    @Autowired
    private MapRepositoryInterface mapRepository;
    @Transactional
    public List<Driver> getAllDrivers() {
        return driversRepository.getAllDrivers();
    }
    @Transactional
    public void addDriver(Driver driver) {
        driversRepository.addDriver(driver);
    }
    @Transactional
    public void updateDriver(DriverDTO driverDTO) {
//        Driver driver = driversRepository.getDriver(driverDTO.getIdDriver());
//        driver.setName(driverDTO.getName());
//        driver.setSecondName(driverDTO.getSecondName());
//        driver.setPersonalNumber(driverDTO.getPersonalNumber());
//        driver.setHoursWorked(driverDTO.getHoursWorked());
//        driver.setStatus(driverDTO.getStatus());
//        driver.setCity(driverDTO.getCity());
//        driver.setWaggon(driverDTO.getWaggon());
//        driversRepository.updateDriver(driver);
    }
    @Transactional
    public Driver getDriver(int id) {
        Driver driver = driversRepository.getDriver(id);
        Map city = mapRepository.findCityById(driver.getIdDriver());
        Waggon waggon = waggonRepository.getWaggon(driver.getIdDriver());
//        DriverDTO driverDTO = new DriverDTO(driver.getIdDriver(),driver.getPersonalNumber(), driver.getName(), driver.getSecondName(), driver.getHoursWorked(), driver.getStatus(), city, waggon);
        return driver;
    }
    @Transactional
    public void removeDriver(int id) {
        driversRepository.removeDriver(id);
    }


}