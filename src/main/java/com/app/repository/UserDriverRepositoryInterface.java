package com.app.repository;


import com.app.model.Driver;
import com.app.model.UserDriver;

public interface UserDriverRepositoryInterface {

    UserDriver createUserDriver(UserDriver userDriver);

    Driver findDriverIdByUsername(String username);

    boolean isUserDriverExist(String username);
}
