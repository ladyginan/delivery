package com.app.service;

import com.app.model.Driver;
import com.app.model.WayPoint;

import java.util.List;

public interface DriverLoginServiceInterface {
    List<Driver> findAllCompanions(int idDriver);

    String findCurrentWaggon(int idDriver);

    int findOrderNumber(int idDriver);

    List<WayPoint> findAllOrderPoints(int idDriver);

    int settingDriverTime(int idDriver);

}
