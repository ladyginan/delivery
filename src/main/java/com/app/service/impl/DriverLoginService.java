package com.app.service.impl;

import com.app.model.Driver;
import com.app.model.WayPoint;
import com.app.repository.DriverLoginRepositoryInterface;
import com.app.service.DriverLoginServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DriverLoginService implements DriverLoginServiceInterface {
    @Autowired
    private DriverLoginRepositoryInterface driverLoginRepository;
    @Transactional(readOnly = true)
    @Override
    public List<Driver> findAllCompanions(int idDriver) {
        return driverLoginRepository.findAllCompanions(idDriver);
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
    public List<WayPoint> findAllOrderPoints(int idDriver) {
        return null;
    }

    @Override
    public int settingDriverTime(int idDriver) {
        return 0;
    }

}
