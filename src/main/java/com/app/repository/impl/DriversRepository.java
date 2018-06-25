package com.app.repository.impl;

import com.app.model.Driver;
import com.app.repository.DriversRepositoryInterface;
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
public class DriversRepository implements DriversRepositoryInterface {
    //Hibernate+Spring
    @Autowired
    private final SessionFactory factory;

    public DriversRepository(SessionFactory factory) {
        this.factory = factory;
    }

    //show driver list

    public List<Driver> getAllDrivers() {
        try{
            List<Driver> drivers = factory.getCurrentSession().createQuery("from Driver").list();
            return drivers;
        }catch (QueryException e){
            log.error("DAO: return list of drivers");
            return null;
        }
    }

    //add new driver


    public Driver addDriver(Driver driver) {
       try{
           factory.getCurrentSession().save(driver);
            Driver driverSave = getDriver(driver.getIdDriver());
            log.info("Driver was saved.");
            return driverSave;
    }catch(ConstraintViolationException e){
           e.printStackTrace();
           log.error("Driver is existing!");
           return null;
    }
}

    //updating driver fields

    public Driver updateDriver(Driver driver) {
        try {
            factory.getCurrentSession().update(driver);
            Driver driverCheck = factory.getCurrentSession().get(Driver.class, driver.getIdDriver());
            log.info("Driver was updated.");
            return driverCheck;
        }catch (QueryException e){
            log.error("DAO: update driver exception.");
            return null;
        }
    }

    //get driver by id

    public Driver getDriver(int id) {
        try{
            Driver driver = (Driver) factory.getCurrentSession().get(Driver.class, id);
            log.info("Driver is founded.");
            return driver;
        }catch (QueryException e){
            e.printStackTrace();
            log.error("DAO: get driver exception.");
            return null;
        } catch (ClassCastException e){
            e.printStackTrace();
            log.error("DAO: class cast driver exception.");
            return null;
        } catch (EntityNotFoundException e){
            e.printStackTrace();
            log.error("Driver not found.");
            return null;
        }
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
        try {
            Driver driver = getDriver(id);
            factory.getCurrentSession().delete(driver);
            log.info("Driver was deleted.");
            return driver;
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            log.error("This driver doesn't exist.");
            return null;
        }
    }


}