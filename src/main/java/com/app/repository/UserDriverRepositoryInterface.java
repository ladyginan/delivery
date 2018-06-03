package com.app.repository;


import com.app.model.Driver;
import com.app.model.UserDriver;

import java.util.Map;

public interface UserDriverRepositoryInterface {

    UserDriver createUserDriver(UserDriver userDriver);

    Driver findDriverIdByUsername(String username);
}
