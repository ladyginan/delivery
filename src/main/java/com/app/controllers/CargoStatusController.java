package com.app.controllers;

import com.app.model.Cargo;
import com.app.service.CargoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/status")
public class CargoStatusController {
    @Autowired
    private CargoServiceInterface cargoService;

    @RequestMapping(value = "/cargoes", method = RequestMethod.GET)
    public ModelAndView getAllDrivers() {
        List<Cargo> cargoes = cargoService.getAllCargoes();
        ModelAndView modelAndView = new ModelAndView("cargoStatus");
        modelAndView.addObject("cargoes", cargoes);
        return modelAndView;
    }
}

