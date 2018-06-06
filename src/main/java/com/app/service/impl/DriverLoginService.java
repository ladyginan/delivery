package com.app.service.impl;

import com.app.DTO.DriverDTO;
import com.app.DTO.WayPointDTO;
import com.app.model.Driver;
import com.app.model.WayPoint;
import com.app.repository.DriverLoginRepositoryInterface;
import com.app.service.DriverLoginServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
            DriverDTO driverDTO = new DriverDTO(driver);
            listDriverDTO.add(driverDTO);
        }
        return listDriverDTO;
    }

    @Transactional(readOnly = true)
    @Override
    public String findCurrentWaggon(int idDriver) {
        return driverLoginRepository.findCurrentWaggon(idDriver);
    }

    @Override
    public int findOrderNumber(int idDriver) {
        return 0;
    }

    @Override
    public List<WayPointDTO> findAllOrderPoints(int idDriver) {
        List<WayPoint> wayPoints = driverLoginRepository.findAllOrderPoints(idDriver);
        List<WayPointDTO> wayPointsDTO = new ArrayList<>();
        for (WayPoint wayPoint : wayPoints) {
            WayPointDTO pointDTO = new WayPointDTO(wayPoint);
            wayPointsDTO.add(pointDTO);
        }
        return wayPointsDTO;
    }

    @Override
    public int settingDriverTime(int idDriver) {
        return 0;
    }

}
