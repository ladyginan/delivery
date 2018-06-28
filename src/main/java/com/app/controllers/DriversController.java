package com.app.controllers;

import com.app.DTO.DriverDTO;
import com.app.configuration.rabbitMq.Producer;
import com.app.model.Driver;
import com.app.service.DriverJsonServiceInterface;
import com.app.service.DriverServiceInterface;
import com.app.service.MapServiceInterface;
import com.app.service.WaggonServiceInterface;
import com.app.service.impl.DriverJsonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
@Slf4j
@Controller
@RequestMapping(path = "/drivers")
public class DriversController {
    @Autowired
    private DriverServiceInterface driverService;
    @Autowired
    private WaggonServiceInterface waggonService;
    @Autowired
    private MapServiceInterface mapService;
    @Autowired
    private Producer producer;
    @Autowired
    private DriverJsonServiceInterface driverJsonService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<DriverDTO> getAllDriversJson() {
        List<DriverDTO> drivers = driverService.getAllDriversJson();
        return drivers;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    DriverDTO editDriver(@RequestBody DriverDTO driverDTO) {
        System.out.println(driverDTO);
        driverService.updateDriver(driverDTO);
        return new DriverDTO();
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
    public String addingDriver(@Valid Driver driver,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("waggons", waggonService.getAllWaggons());
            model.addAttribute("maps", mapService.getAllMap());
            return "driverForm";
        }
        try{
            driverService.addDriver(driver);
            producer.sendMessageDrivers(driverJsonService.getDriverJson());
        }catch (ConstraintViolationException e){
            log.error("Driver isn't adding.");
        }
        String message = "Driver was successfully added";
        model.addAttribute("message", message);
        return "welcome";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editDriverPage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("driverEdit");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    DriverDTO getDriverById(@PathVariable int id) {
        try{
        DriverDTO driverDTO = driverService.getDriverDTO(id);
            return driverDTO;
        }catch (EntityNotFoundException e){
            log.error("Driver not found");
            return null;
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public @ResponseBody
    DriverDTO editDriver(@RequestBody DriverDTO driverDTO, @PathVariable int id) {
        DriverDTO savedDriver = driverService.updateDriver(driverDTO);
        producer.sendMessageDrivers(driverJsonService.getDriverJson());
        return savedDriver;
    }

    @RequestMapping(value = "/edit/success", method = RequestMethod.GET)
    public ModelAndView editDriverSuccessMessage() {
        ModelAndView modelAndView = new ModelAndView("welcome");
        String message = "Driver was successfully edited.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteDriver(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        try{
            driverService.removeDriver(id);
            producer.sendMessageDrivers(driverJsonService.getDriverJson());
        } catch (EntityNotFoundException e){
            log.error("Driver not found.");
            String message = "Driver not found.";
            modelAndView.addObject("message", message);
            return modelAndView;
        } catch (ConstraintViolationException e){
            log.error("Can't delete driver. Please make sure, that he has not have order.");
            String message = "Can't delete this driver.";
            modelAndView.addObject("message", message);
            return modelAndView;
        }
        String message = "Driver was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}