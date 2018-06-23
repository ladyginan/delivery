package com.app.service;

import com.app.DTO.DriverDTO;
import com.app.DTO.SaveChangeDriverDTO;
import com.app.DTO.UserDriverDTO;
import com.app.model.UserDriver;

public interface UserDriverServiceInterface {

    UserDriver createUserDriver(UserDriverDTO userDriverDTO);

    DriverDTO findDriverIdByUsername(String username);

    void saveChangeDriver(SaveChangeDriverDTO saveChangeDriverDTO);
}
