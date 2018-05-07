package com.app.repository.api;

import com.app.model.Driver;

import java.util.List;

public interface DriversRepositoryInterface {

    Driver addDriver(Driver account);
    void removeDriver(Driver account);
    void updateDriver(Driver account);


}