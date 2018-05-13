package com.app.controllers;

import com.app.model.Driver;
import com.app.service.api.DriverServiceInterface;
import com.app.service.impl.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/drivers")
public class DriversController {
    @Autowired
    private DriverServiceInterface driverService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        ModelAndView modelAndView = new ModelAndView("listOfDrivers");
        modelAndView.addObject("drivers", drivers);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addDriverPage() {
        ModelAndView modelAndView = new ModelAndView("driverForm");
        modelAndView.addObject("driver", new Driver());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addingDriver(@ModelAttribute("driver") Driver driver) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        driverService.addDriver(driver);
        String message = "Driver was successfully added";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editDriverPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("driverEdit");
        Driver driver = driverService.getDriver(id);
        modelAndView.addObject("driver", driver);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editDriver(@ModelAttribute Driver driver, @PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("editDriverFrom");
        driverService.updateDriver(driver);
        String message = "Driver was successfully edited.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteDriver(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        driverService.removeDriver(id);
        String message = "Driver was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}