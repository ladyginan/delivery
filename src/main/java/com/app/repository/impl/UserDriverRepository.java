package com.app.repository.impl;

import com.app.model.Driver;
import com.app.model.UserDriver;
import com.app.repository.DriversRepositoryInterface;
import com.app.repository.UserDriverRepositoryInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDriverRepository implements UserDriverRepositoryInterface {
    @Autowired
    private final SessionFactory factory;
    @Autowired
    private DriversRepositoryInterface driversRepository;


    public UserDriverRepository(SessionFactory factory) {
        this.factory = factory;
    }

    public List<Integer> getAllDriversId() {
        List<Integer> list = factory.getCurrentSession().createQuery("Select idDriver from Driver").list();
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
        return savedUserDriver;
    }

    public boolean isUserDriverExist(String username) {
        Query query = factory.getCurrentSession().createQuery("Select D from UserDriver D where D.idUser = :username");
        query.setParameter("username", username);
        if (((org.hibernate.query.Query) query).list().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public Driver findDriverIdByUsername(String username) {
        Query query = factory.getCurrentSession().createQuery("Select D from UserDriver D where D.idUser = :username");
        query.setParameter("username", username);
        List<UserDriver> list = ((org.hibernate.query.Query) query).list();
        Driver driver = driversRepository.getDriver(list.get(0).getIdDriver());
        return driver;
    }
}
