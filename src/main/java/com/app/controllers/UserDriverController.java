package com.app.controllers;

import com.app.DTO.DriverDTO;
import com.app.DTO.UserDriverDTO;
import com.app.model.UserDriver;
import com.app.service.DriverServiceInterface;
import com.app.service.UserDriverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(path = "/driverInfo")
public class UserDriverController {
    @Autowired
    UserDriverServiceInterface userDriverService;
    @Autowired
    DriverServiceInterface driverService;



    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView driverInfoPage (@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("DriverInfo");
        return modelAndView;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    DriverDTO getDriverDTOByUser(@PathVariable int id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        DriverDTO driverDTO = userDriverService.findDriverIdByUsername(username);
        return driverDTO;
    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
//    public @ResponseBody
//    DriverDTO editDriverUser(@RequestBody DriverDTO driverDTO, @PathVariable int id) {
////        DriverDTO savedWaggon = driverService.saveChange(DriverDTO);
//        return savedWaggon;
//    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    UserDriver createUserDriver(@RequestBody UserDriverDTO userDriverDTO) {
        System.out.println(userDriverDTO);
        userDriverService.createUserDriver(userDriverDTO);
        return new UserDriver();
    }
}
