package com.app.repository.impl;

import com.app.model.Driver;
import com.app.repository.DriversRepositoryInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


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

    public void addDriver(Driver driver) {
        factory.getCurrentSession().save(driver);
    }

    //updating driver fields

    public void updateDriver(Driver driver) {
        Driver driverToUpdate = getDriver(driver.getIdDriver());

        driverToUpdate.setName(driver.getName());
        driverToUpdate.setSecondName(driver.getSecondName());
        driverToUpdate.setPersonalNumber(driver.getPersonalNumber());
        driverToUpdate.setStatus(driver.getStatus());
        driverToUpdate.setHoursWorked(driver.getHoursWorked());
        driverToUpdate.setCity(driver.getCity());
        factory.getCurrentSession().update(driverToUpdate);
    }

    //get driver by id

    public Driver getDriver(int id) {
        Driver driver = (Driver) factory.getCurrentSession().get(Driver.class, id);
        return driver;
    }

    // remove driver

    public void removeDriver(int id) {
        Driver driver = getDriver(id);
        factory.getCurrentSession().delete(driver);
    }
}