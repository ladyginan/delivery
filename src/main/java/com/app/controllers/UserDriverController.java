package com.app.controllers;

import com.app.DTO.UserDriverDTO;
import com.app.model.Driver;
import com.app.model.UserDriver;
import com.app.service.UserDriverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(path = "/selectProfile")
public class UserDriverController {
    @Autowired
    UserDriverServiceInterface userDriverService;


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    UserDriver createOrder(@RequestBody UserDriverDTO userDriverDTO) {
        System.out.println(userDriverDTO);
        userDriverService.createUserDriver(userDriverDTO);
        return new UserDriver();
    }
}
