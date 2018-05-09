package com.app.controllers;
import com.app.model.Driver;
import com.app.service.api.DriverServiceInterface;
import com.app.service.impl.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/drivers")
public class DriversController {
    @Autowired
    private DriverServiceInterface driverService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(driverService.getAllDrivers());
    }

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addDriverPage() {
        ModelAndView modelAndView = new ModelAndView("driverForm");
        modelAndView.addObject("driver", new Driver());
        return modelAndView;
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView addingDriver(@ModelAttribute Driver driver){
        ModelAndView modelAndView = new ModelAndView("welcome");
        driverService.addDriver(driver);

        String message = "Driver was successfully added";
        modelAndView.addObject("message", message);

        return modelAndView;
    }
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-team-form");
        Driver team = driverService.getDriver(id);
        modelAndView.addObject("team",team);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView editDriver(@ModelAttribute Driver driver, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("home");

        driverService.updateDriver(driver);

        String message = "Driver was successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteTeam(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        driverService.removeDriver(id);
        String message = "Driver was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}