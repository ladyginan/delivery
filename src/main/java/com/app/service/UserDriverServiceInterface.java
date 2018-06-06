package com.app.service;

import com.app.DTO.DriverDTO;
import com.app.DTO.UserDriverDTO;
import com.app.model.UserDriver;

public interface UserDriverServiceInterface {

    UserDriver createUserDriver(UserDriverDTO userDriverDTO);

    DriverDTO findDriverIdByUsername(String username);
}
