package com.app.service;

import com.app.DTO.DriverDTO;
import com.app.DTO.WayPointDTO;
import com.app.model.Driver;
import com.app.model.WayPoint;

import java.util.List;

public interface DriverLoginServiceInterface {
    List<DriverDTO> findAllCompanions(int idDriver);

    String findCurrentWaggon(int idDriver);

    int findOrderNumber(int idDriver);

    List<WayPointDTO>  findAllOrderPoints(int idDriver);

    int settingDriverTime(int idDriver);

}
