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

import java.util.List;


@Controller
@RequestMapping(path = "/driverPage")
public class UserDriverController {
    @Autowired
    UserDriverServiceInterface userDriverService;
    @Autowired
    DriverServiceInterface driverService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<DriverDTO> getAllDriversJson() {
        List<DriverDTO> drivers = driverService.getAllDriversJson();
        return drivers;
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView driverInfoPage (@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("driverInfo");
        return modelAndView;
    }
    @RequestMapping(path = "driverInfo/{id}", method = RequestMethod.GET)
    public @ResponseBody
    DriverDTO getDriverDTOByUser(@PathVariable int id) {
        DriverDTO driverDTO = driverService.getDriverDTO(id);
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
