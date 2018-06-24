package com.app.repository.impl;

import com.app.model.Driver;
import com.app.repository.DriversRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class DriversRepository implements DriversRepositoryInterface {
    //Hibernate+Spring
    @Autowired
    private final SessionFactory factory;

    public DriversRepository(SessionFactory factory) {
        this.factory = factory;
    }

    //show driver list

    public List<Driver> getAllDrivers() {
        List<Driver> drivers = factory.getCurrentSession().createQuery("from Driver").list();
        return drivers;
    }

    //add new driver


    public Driver addDriver(Driver driver) {
        factory.getCurrentSession().save(driver);
        Driver driverSave = getDriver(driver.getIdDriver());
        return driverSave;
    }

    //updating driver fields

    public Driver updateDriver(Driver driver) {
        factory.getCurrentSession().update(driver);
        return factory.getCurrentSession().get(Driver.class, driver.getIdDriver());
    }

    //get driver by id

    public Driver getDriver(int id) {
        Driver driver = (Driver) factory.getCurrentSession().get(Driver.class, id);
        return driver;
    }

    @Override
    public int getAllFreeDriversCount() {
        List<Driver> list = getAllDrivers();
        int count = 0;
        for(Driver driver : list){
            if(driver.getOrder() != null){

            } else{
                count++;
            }
        }
        return count;
    }

    @Override
    public int getAllBusyDriversCount() {
        List<Driver> list = getAllDrivers();
        int count = 0;
        for(Driver driver : list){
            if(driver.getOrder() != null){
                count++;
            }
        }
        return count;
    }

    // remove driver

    public Driver removeDriver(int id) {
        Driver driver = getDriver(id);
        factory.getCurrentSession().delete(driver);
        return driver;
    }


}