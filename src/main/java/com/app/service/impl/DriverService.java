package com.app.service.impl;

import com.app.DTO.DriverDTO;
import com.app.model.Driver;
import com.app.model.Enums.DriverStatus;
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
        Map city = mapRepository.findCityById(driverDTO.getMapId());
        Waggon waggon = waggonRepository.getWaggon(driverDTO.getWaggon());
        Driver driver = new Driver(
              driverDTO.getPersonalNumber(),
              driverDTO.getName(),
              driverDTO.getSecondName(),
              driverDTO.getHoursWorked(),
              driverDTO.getStatus(),
              city,
              waggon);
        driver.setIdDriver(driverDTO.getIdDriver());
        driversRepository.updateDriver(driver);
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
    @Transactional
    public void removeDriver(int id) {
        driversRepository.removeDriver(id);
    }


}