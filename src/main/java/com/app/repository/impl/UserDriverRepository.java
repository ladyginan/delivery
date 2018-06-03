package com.app.repository.impl;

import com.app.model.Driver;
import com.app.model.User;
import com.app.model.UserDriver;
import com.app.repository.DriversRepositoryInterface;
import com.app.repository.UserDriverRepositoryInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDriverRepository implements UserDriverRepositoryInterface {
    @Autowired
    private final SessionFactory factory;
    @Autowired
    private DriversRepositoryInterface driversRepository;


    public UserDriverRepository(SessionFactory factory) {
        this.factory = factory;
    }

    public List<Integer> getAllDriversId(){
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

    @Override
    public Driver findDriverIdByUsername(String username) {
////       List<UserDriver> list = factory.getCurrentSession().createQuery("Select D from UserDriver D where D.idUser = :username").list();
//        int id = list.get(0).getIdDriver();
//        if(id == 0){
//            id = -1;
//        }
        Driver driver = driversRepository.getDriver(1);
        return driver;
    }
}
