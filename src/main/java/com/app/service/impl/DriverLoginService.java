package com.app.service.impl;

import com.app.DTO.DriverDTO;
import com.app.DTO.WayPointDTO;
import com.app.model.Driver;
import com.app.model.WayPoint;
import com.app.repository.DriverLoginRepositoryInterface;
import com.app.service.DriverLoginServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class DriverLoginService implements DriverLoginServiceInterface {
    @Autowired
    private DriverLoginRepositoryInterface driverLoginRepository;

    @Transactional(readOnly = true)
    @Override
    public List<DriverDTO> findAllCompanions(int idDriver) {
        List<Driver> listDriver = driverLoginRepository.findAllCompanions(idDriver);
        List<DriverDTO> listDriverDTO = new ArrayList<>();
        for (Driver driver : listDriver) {

            DriverDTO driverDTO = new DriverDTO(driver,driver.getOrder().getIdOrder());
            listDriverDTO.add(driverDTO);
        }
        log.info("List of all companions in service.");
        return listDriverDTO;
    }

    @Transactional(readOnly = true)
    @Override
    public String findCurrentWaggon(int idDriver) {
        log.info("Current waggon is found.");
        return driverLoginRepository.findCurrentWaggon(idDriver);
    }
    @Transactional
    @Override
    public int findOrderNumber(int idDriver) {

        return 0;
    }
    @Transactional
    @Override
    public List<WayPointDTO> findAllOrderPoints(int idDriver) {
        List<WayPoint> wayPoints = driverLoginRepository.findAllOrderPoints(idDriver);
        List<WayPointDTO> wayPointsDTO = new ArrayList<>();
        for (WayPoint wayPoint : wayPoints) {
            WayPointDTO pointDTO = new WayPointDTO(wayPoint,wayPoint.getIdWayPoint());
            wayPointsDTO.add(pointDTO);
        }
        log.info("List of order points in service.");
        return wayPointsDTO;
    }
    @Transactional
    @Override
    public int settingDriverTime(int idDriver) {
        return 0;
    }

}
