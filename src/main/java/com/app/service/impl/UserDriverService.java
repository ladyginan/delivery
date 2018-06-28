package com.app.service.impl;

import com.app.DTO.DriverDTO;
import com.app.DTO.SaveChangeDriverDTO;
import com.app.DTO.UserDriverDTO;
import com.app.model.Cargo;
import com.app.model.Driver;
import com.app.model.UserDriver;
import com.app.model.WayPoint;
import com.app.repository.*;
import com.app.service.UserDriverServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class UserDriverService implements UserDriverServiceInterface {
    @Autowired
    private UserDriverRepositoryInterface userDriverRepository;
    @Autowired
    private DriversRepositoryInterface driversRepository;
    @Autowired
    private CargoRepositoryInterface cargoRepository;

    @Transactional
    @Override
    public UserDriver createUserDriver(DriverDTO driverDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDriver userDriver = new UserDriver(auth.getName(), driverDTO.getIdDriver());
        userDriver = userDriverRepository.createUserDriver(userDriver);
        return userDriver;
    }

    @Transactional
    @Override
    public DriverDTO findDriverIdByUsername(String username) {
        DriverDTO driverDTO = new DriverDTO();
        if (userDriverRepository.isUserDriverExist(username)) {
            Driver driver = userDriverRepository.findDriverIdByUsername(username);
            driverDTO = new DriverDTO(driver);
        } else {
            driverDTO.setIdDriver(-1);
        }

        return driverDTO;
    }
@Transactional
    @Override
    public void saveChangeDriver(SaveChangeDriverDTO saveChangeDriverDTO) {
        Driver driver = driversRepository.getDriver(saveChangeDriverDTO.getIdDriver());
        driver.setStatus(saveChangeDriverDTO.getDriverStatus());
        List<WayPoint> pointList = driver.getOrder().getPointList();
        Cargo cargo = pointList.get(0).getCargo();
        cargo.setStatus(saveChangeDriverDTO.getOrderCargoStatus());
        cargoRepository.updateCargo(cargo);
        driversRepository.updateDriver(driver);
    }
}
