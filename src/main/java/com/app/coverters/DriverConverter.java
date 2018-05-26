package com.app.coverters;

import com.app.model.Driver;
import com.app.service.DriverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DriverConverter implements Converter<Object, Driver> {

    @Autowired
    private DriverServiceInterface driverService;

    @Override
    public Driver convert(Object source) {
        Integer id = Integer.parseInt((String)source);
        Driver driver = driverService.getDriver(id);
        return driver;
    }
}
