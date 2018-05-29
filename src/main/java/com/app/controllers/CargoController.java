package com.app.controllers;

import com.app.model.Cargo;
import com.app.service.CargoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/cargoes")
public class CargoController {
    @Autowired
    private CargoServiceInterface cargoService;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addCargoPage() {
        ModelAndView modelAndView = new ModelAndView("cargoForm");
        modelAndView.addObject("cargo", new Cargo());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addingCargo(@ModelAttribute("cargo") Cargo cargo) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        cargoService.addCargo(cargo);
        String message = "Cargo was successfully added";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}

