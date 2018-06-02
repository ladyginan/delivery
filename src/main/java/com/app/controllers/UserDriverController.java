package com.app.controllers;

import com.app.DTO.UserDriverDTO;
import com.app.model.Driver;
import com.app.model.UserDriver;
import com.app.service.DriverServiceInterface;
import com.app.service.UserDriverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(path = "/selectProfile")
public class UserDriverController {
    @Autowired
    UserDriverServiceInterface userDriverService;
    @Autowired
    DriverServiceInterface driverService;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public @ResponseBody
    List<Driver> getAllDriversJson() {
        List<Driver> drivers = driverService.getAllDrivers();
        return drivers;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    UserDriver createUserDriver(@RequestBody UserDriverDTO userDriverDTO) {
        System.out.println(userDriverDTO);
        userDriverService.createUserDriver(userDriverDTO);
        return new UserDriver();
    }
}
