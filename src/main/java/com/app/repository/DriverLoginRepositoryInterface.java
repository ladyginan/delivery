package com.app.repository;

import com.app.model.Driver;
import com.app.model.WayPoint;

import java.util.List;

public interface DriverLoginRepositoryInterface {
    int findDriverPersonalNumber(int idDriver);

    List<Driver> findAllCompanions(int idDriver);

    String findCurrentWaggon(int idDriver);

    List<WayPoint> findAllOrderPoints(int idDriver);

    int settingDriverTime(int idDriver);

}
