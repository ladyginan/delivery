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
    private DriversRepository driversRepository;

    public List<Driver> getAllDrivers() {
        return driversRepository.getAllDrivers();
    }


}