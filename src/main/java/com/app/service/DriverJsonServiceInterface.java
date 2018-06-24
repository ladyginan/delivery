package com.app.service;

import com.app.configuration.rabbitMq.DriverJson;
import com.app.model.Driver;

import java.util.List;

public interface DriverJsonServiceInterface {

    int getAllDriversCount();

    int getFreeDriversCount();

    int getBusyDriversCount();

    DriverJson getDriverJson();

}
