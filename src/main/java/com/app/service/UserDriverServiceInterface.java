package com.app.service;

import com.app.DTO.UserDriverDTO;
import com.app.model.UserDriver;

import java.util.Map;

public interface UserDriverServiceInterface {

    UserDriver createUserDriver(UserDriverDTO userDriverDTO);
}
