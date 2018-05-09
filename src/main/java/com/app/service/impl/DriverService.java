package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Driver;
import com.app.repository.api.DriversRepositoryInterface;
import com.app.service.api.DriverServiceInterface;

@Service
public class DriverService implements DriverServiceInterface {
    @Autowired
    private DriversRepositoryInterface driversRepository;

    @Override
    public List<Driver> getAllDrivers() {
        return driversRepository.getAllDrivers();
    }


}