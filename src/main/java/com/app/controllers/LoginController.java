package com.app.controllers;

import com.app.DTO.DriverDTO;
import com.app.DTO.SaveChangeDriverDTO;
import com.app.DTO.UserDriverDTO;
import com.app.DTO.WayPointDTO;
import com.app.model.UserDriver;
import com.app.service.DriverLoginServiceInterface;
import com.app.service.DriverServiceInterface;
import com.app.service.UserDriverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/driverPage")
public class LoginController {
    @Autowired
    DriverLoginServiceInterface driverLoginService;
    @Autowired
    DriverServiceInterface driverService;
    @Autowired
    UserDriverServiceInterface userDriverService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<DriverDTO> getAllDriversJson() {
        List<DriverDTO> drivers = driverService.getAllDriversJson();
        return drivers;
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView driverInfoPage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("driverInfo");
        return modelAndView;
    }

    @RequestMapping(path = "/driverInfo/{id}", method = RequestMethod.GET)
    public @ResponseBody
    DriverDTO getDriverDTOByUser(@PathVariable int id) {
        DriverDTO driverDTO = driverService.getDriverDTO(id);
        return driverDTO;
    }

    @RequestMapping(path = "/companions/{id}", method = RequestMethod.GET)
    public @ResponseBody
    List<DriverDTO> loadCompanion(@PathVariable int id) {
        List<DriverDTO> list = driverLoginService.findAllCompanions(id);
        return list;
    }

    @RequestMapping(path = "/points/{id}", method = RequestMethod.GET)
    public @ResponseBody
    List<WayPointDTO> loadWayPoints(@PathVariable int id) {
        List<WayPointDTO> points = driverLoginService.findAllOrderPoints(id);
        return points;
    }

    @RequestMapping(value = "/driverInfo/success", method = RequestMethod.POST)
    public ModelAndView driverInfoSuccessMessage() {
        ModelAndView modelAndView = new ModelAndView("driverInfo");
        String message = "You was successfully login in.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }


    @RequestMapping(path = "/driverInfo/{id}", method = RequestMethod.POST)
    public @ResponseBody
    UserDriver createSaveChangeDriverDTO(@RequestBody SaveChangeDriverDTO saveChangeDriverDTO, @PathVariable int id, Model model) {
        System.out.println(saveChangeDriverDTO);
        userDriverService.saveChangeDriver(saveChangeDriverDTO);
        String message = "You was successfully change your info";
        model.addAttribute("message", message);
        return new UserDriver();
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
    UserDriver createUserDriver(@RequestBody DriverDTO driverDTO) {
        userDriverService.createUserDriver(driverDTO);
        return new UserDriver();
    }
}
