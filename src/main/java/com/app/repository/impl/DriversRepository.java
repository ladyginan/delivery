package com.app.repository.impl;

import com.app.model.Driver;
import com.app.repository.DriversRepositoryInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.QueryException;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.sql.SQLNonTransientException;
import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class DriversRepository implements DriversRepositoryInterface {
    //Hibernate+Spring
    private final SessionFactory factory;
    //show driver list

    public List<Driver> getAllDrivers() {
            List<Driver> drivers = factory.getCurrentSession().createQuery("from Driver").list();
            log.info("Driver list is load form DB.");
            return drivers;
    }

    //add new driver
    public Driver addDriver(Driver driver) throws ConstraintViolationException{
             factory.getCurrentSession().save(driver);
            Driver driverSave = getDriver(driver.getIdDriver());
            log.info("Driver is saved.");
            return driverSave;
}

    //updating driver fields
    public Driver updateDriver(Driver driver) {
            factory.getCurrentSession().update(driver);
            Driver driverCheck = factory.getCurrentSession().get(Driver.class, driver.getIdDriver());
            log.info("Driver is updated.");
            return driverCheck;
    }

    //get driver by id
    public Driver getDriver(int id) throws EntityNotFoundException{
            Driver driver = (Driver) factory.getCurrentSession().get(Driver.class, id);
            log.info("Driver is founded.");
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
        log.info("Count all free drivers");
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
        log.info("Count all busy drivers");
        return count;
    }

    // remove driver
    public Driver removeDriver(int id) throws EntityNotFoundException, ConstraintViolationException{
            Driver driver = getDriver(id);
            factory.getCurrentSession().delete(driver);
            log.info("Driver is deleted.");
            return driver;
    }
}