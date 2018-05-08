package com.app.repository.api;

import com.app.model.Driver;

import java.util.List;

public interface DriversRepositoryInterface {

    Driver addDriver(Driver driver);
    void removeDriver(Driver driver);
    void updateDriver(Driver driver);


}