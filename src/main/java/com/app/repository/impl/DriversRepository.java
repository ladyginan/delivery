package com.app.repository.impl;
import com.app.model.Driver;
import com.app.repository.api.DriversRepositoryInterface;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


// imitation JPA
@Repository
public class DriversRepository implements DriversRepositoryInterface {
    private List<Driver> drivers = Arrays.asList(
            new Driver("Антон", "Петров", 44455, 8, "free", "Москва", "Фура№5"),
            new Driver("Антон", "Петров", 44455, 8, "free", "Москва", "Фура№5"));



    //Hibernate+Spring
    @Autowired
    private final SessionFactory factory;
    public DriversRepository(SessionFactory factory) {
        this.factory = factory;
    }
//don't work
    public List<Driver> getAllDrivers() {
        return factory.getCurrentSession().createQuery("from Driver").list();
    }
//add new driver
    public void addDriver(Driver driver) {
        factory.getCurrentSession().save(driver);
    }

//updating driver fields
    public void updateDriver(Driver driver) {
        Driver driverToUpdate = getDriver(driver.getIdDriver());
        driverToUpdate.setName(driver.getSecondName());
        driverToUpdate.setSecondName(driver.getSecondName());
        driverToUpdate.setIdDriver(driver.getIdDriver());
        driverToUpdate.setStatus(driver.getStatus());
        driverToUpdate.setHoursWorked(driver.getHoursWorked());
        driverToUpdate.setCurrentWaggon(driver.getCurrentWaggon());
        driverToUpdate.setCurrentCity(driver.getCurrentCity());
    }
//get driver by id
    public Driver getDriver(int id) {
        Driver driver = (Driver) factory.getCurrentSession().get(Driver.class, id);
        return driver;
    }

    // remove driver
    public void removeDriver(int id) {
        factory.getCurrentSession().delete(id);
    }




}