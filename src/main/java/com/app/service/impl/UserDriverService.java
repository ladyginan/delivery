package com.app.service.impl;

import com.app.DTO.DriverDTO;
import com.app.DTO.UserDriverDTO;
import com.app.model.Driver;
import com.app.model.Map;
import com.app.model.UserDriver;
import com.app.model.Waggon;
import com.app.repository.MapRepositoryInterface;
import com.app.repository.UserDriverRepositoryInterface;
import com.app.repository.WaggonRepositoryInterface;
import com.app.service.UserDriverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserDriverService implements UserDriverServiceInterface {
    @Autowired
    private UserDriverRepositoryInterface userDriverRepository;
    @Autowired
    private WaggonRepositoryInterface waggonRepository;
    @Autowired
    private MapRepositoryInterface mapRepository;

@Transactional
    @Override
    public UserDriver createUserDriver(UserDriverDTO userDriverDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDriver userDriver = new UserDriver(auth.getName(),userDriverDTO.getIdDriver());
        userDriver = userDriverRepository.createUserDriver(userDriver);
        return userDriver;
    }
@Transactional
    @Override
    public DriverDTO findDriverIdByUsername(String username) {
        Driver driver = userDriverRepository.findDriverIdByUsername(username);
        int mapId = driver.getCity().getIdCity();
        int waggon = driver.getWaggon().getIdWaggon();
        DriverDTO driverDTO = new DriverDTO(driver);
        driverDTO.setIdDriver(0);
        return driverDTO;
    }
}
