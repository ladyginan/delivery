package com.app.controllers;
import com.app.model.Driver;
import com.app.service.api.DriverServiceInterface;
import com.app.service.impl.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newDriver(Map<String, Object> model) {
        model.put("driver", new Driver());
        return "driverForm.";
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView addingDriver(@ModelAttribute Driver driver){
        ModelAndView modelAndView = new ModelAndView("welcome");
        driverService.addDriver(driver);

        String message = "Driver was successfully added";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

}