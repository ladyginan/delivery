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
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService implements DriverServiceInterface {
    @Autowired
    private DriversRepositoryInterface driversRepository;
    @Autowired
    private WaggonRepositoryInterface waggonRepository;

    public DriverService(DriversRepositoryInterface driversRepository,WaggonRepositoryInterface waggonRepository) {
        this.driversRepository = driversRepository;
        this.waggonRepository = waggonRepository;
    }

    @Autowired
    private MapRepositoryInterface mapRepository;

    @Transactional
    @Override
    public List<Driver> getAllDrivers() {
        return driversRepository.getAllDrivers();
    }

    @Transactional
    public List<DriverDTO> getAllDriversJson() {
        List<Driver> drivers = driversRepository.getAllDrivers();
        List<DriverDTO> driversDTO = new ArrayList<>();
        for (Driver driver : drivers) {
            driversDTO.add(new DriverDTO(driver));
        }

        return driversDTO;
    }

    @Transactional
    public void addDriver(Driver driver) {
        driversRepository.addDriver(driver);
    }

    @Transactional
    public DriverDTO updateDriver(DriverDTO driverDTO) {
        Map city = mapRepository.findCityById(driverDTO.getMapId());
        Waggon waggon = waggonRepository.getWaggon(driverDTO.getWaggon());

        Driver driver = driversRepository.getDriver(driverDTO.getIdDriver());
        driver.setPersonalNumber(driverDTO.getPersonalNumber());
        driver.setName(driverDTO.getName());
        driver.setSecondName(driverDTO.getSecondName());
        driver.setHoursWorked(driverDTO.getHoursWorked());
        driver.setStatus(driverDTO.getStatus());
        driver.setCity(city);
        driver.setWaggon(waggon);

        driver = driversRepository.updateDriver(driver);
        return new DriverDTO(driver);
    }

    @Transactional
    @Override
    public DriverDTO getDriverDTO(int id) {
        Driver driver = driversRepository.getDriver(id);
        DriverDTO driverDTO = new DriverDTO(driver);
        return driverDTO;
    }

    @Transactional
    public Driver getDriver(int id) {
        Driver driver = driversRepository.getDriver(id);
        return driver;
    }

//    @Transactional
//    public Driver getDriverWithOrder(int id) {
//        Driver driver = driversRepository.getDriver(id);
//
//        return driver;
//    }

    @Transactional
    public void removeDriver(int id) {
        driversRepository.removeDriver(id);
    }


}