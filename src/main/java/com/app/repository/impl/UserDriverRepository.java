package com.app.repository.impl;

import com.app.model.Driver;
import com.app.model.UserDriver;
import com.app.repository.DriversRepositoryInterface;
import com.app.repository.UserDriverRepositoryInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Slf4j
@Repository
@AllArgsConstructor
public class UserDriverRepository implements UserDriverRepositoryInterface {
    private final SessionFactory factory;
    @Autowired
    private DriversRepositoryInterface driversRepository;

    public List<Integer> getAllDriversId() {
        List<Integer> list = factory.getCurrentSession().createQuery("Select idDriver from Driver").list();
        log.info("Driver ID list is load form DB.");
        return list;
    }
//
//    public List<Integer> getAllDriversUserId(){
//        List<Integer> listUserDriver = factory.getCurrentSession().createQuery("Select idDriver from UserDriver").list();
//        return listUserDriver;
//    }


    @Override
    public UserDriver createUserDriver(UserDriver userDriver) {
        Integer savedUserDriverId = (Integer) factory.getCurrentSession().save(userDriver);
        UserDriver savedUserDriver = (UserDriver) factory.getCurrentSession().get(UserDriver.class, savedUserDriverId);
        log.info("User-driver is created.");
        return savedUserDriver;
    }

    public boolean isUserDriverExist(String username) {
        Query query = factory.getCurrentSession().createQuery("Select D from UserDriver D where D.idUser = :username");
        query.setParameter("username", username);
        if (((org.hibernate.query.Query) query).list().isEmpty()) {
            log.info("User-driver isn't existed.");
            return false;
        }
        log.info("User-driver is existed.");
        return true;

    }

    @Override
    public Driver findDriverIdByUsername(String username) {
        Query query = factory.getCurrentSession().createQuery("Select D from UserDriver D where D.idUser = :username");
        query.setParameter("username", username);
        List<UserDriver> list = ((org.hibernate.query.Query) query).list();
        Driver driver = driversRepository.getDriver(list.get(0).getIdDriver());
        log.info("Driver is found by username.");
        return driver;
    }
}
