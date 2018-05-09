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



    @Override
    public List<Driver> getAllDrivers() {
        return drivers;
    }

    //Hibernate+Spring

    private final SessionFactory factory;
    @Autowired
    public DriversRepository(SessionFactory factory) {
        this.factory = factory;
    }



    public Driver addDriver(Driver driver) {
        factory.getCurrentSession().save(driver);
        return driver;
    }

    public void removeDriver(Driver driver) {
        factory.getCurrentSession().delete(driver);
    }

    public void updateDriver(Driver driver) {
        factory.getCurrentSession().update(driver);
    }


}