package com.app.controllers;

import com.app.DTO.DriverDTO;
import com.app.model.Driver;
import com.app.model.WayPoint;
import com.app.service.DriverServiceInterface;
import com.app.service.MapServiceInterface;
import com.app.service.WaggonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping(path = "/drivers")
public class DriversController {
    @Autowired
    private DriverServiceInterface driverService;
    @Autowired
    private WaggonServiceInterface waggonService;
    @Autowired
    private MapServiceInterface mapService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Driver> getAllDriversJson() {
        List<Driver> drivers = driverService.getAllDrivers();
        return drivers;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        ModelAndView modelAndView = new ModelAndView("listOfDrivers");
        modelAndView.addObject("drivers", drivers);
        return modelAndView;
    }

    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addDriverPage() {
        ModelAndView modelAndView = new ModelAndView("driverForm");
        modelAndView.addObject("driver", new Driver());
        modelAndView.addObject("waggons", waggonService.getAllWaggons());
        modelAndView.addObject("maps", mapService.getAllMap());
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
    public ModelAndView editDriverPage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("driverEdit");
        DriverDTO driverDTO = driverService.getDriver(id);
        modelAndView.addObject("driverDTO", driverDTO);
        modelAndView.addObject("waggons", waggonService.getAllWaggons());
        modelAndView.addObject("maps", mapService.getAllMap());
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editDriver(@ModelAttribute DriverDTO driverDTO, @PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        driverService.updateDriver(driverDTO);
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