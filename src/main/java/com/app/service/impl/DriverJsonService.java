package com.app.service.impl;

import com.app.configuration.rabbitMq.DriverJson;
import com.app.model.Driver;
import com.app.repository.DriversRepositoryInterface;
import com.app.service.DriverJsonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DriverJsonService implements DriverJsonServiceInterface {
    @Autowired
    DriversRepositoryInterface driversRepository;

    @Transactional
    @Override
    public int getAllDriversCount() {
        List<Driver> list = driversRepository.getAllDrivers();
        int count = list.size();
        return count;
    }

    @Transactional
    @Override
    public int getFreeDriversCount(){
        int count = driversRepository.getAllFreeDriversCount();
        return count;
    }
    @Transactional
    @Override
    public int getBusyDriversCount(){
        int count = driversRepository.getAllFreeDriversCount();
        return count;
    }

    @Transactional
    @Override
    public DriverJson getDriverJson() {
        DriverJson driverJson = new DriverJson(getAllDriversCount(),getFreeDriversCount(),getBusyDriversCount());
        return driverJson;
    }

}
