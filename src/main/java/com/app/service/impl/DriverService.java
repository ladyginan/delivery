package com.app.service.impl;

import com.app.model.Driver;
import com.app.repository.DriversRepositoryInterface;
import com.app.repository.WaggonRepositoryInterface;
import com.app.service.DriverServiceInterface;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class DriverService implements DriverServiceInterface {
    @Autowired
    private DriversRepositoryInterface driversRepository;
    @Autowired
    private WaggonRepositoryInterface waggonRepository;

    public List<Driver> getAllDrivers() {
        return driversRepository.getAllDrivers();
    }

    public void addDriver(Driver driver) {
        driversRepository.addDriver(driver);
    }

    public void updateDriver(Driver driver) {
        driversRepository.updateDriver(driver);
    }

    public Driver getDriver(int id) {
        return driversRepository.getDriver(id);
    }

    public void removeDriver(int id) {
        driversRepository.removeDriver(id);
    }


}