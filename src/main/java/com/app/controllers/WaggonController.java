package com.app.controllers;

import com.app.model.Waggon;
import com.app.service.MapServiceInterface;
import com.app.service.WaggonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/waggons")
public class WaggonController {
    @Autowired
    private WaggonServiceInterface waggonService;
    @Autowired
    private MapServiceInterface mapService;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ModelAndView getAllWaggon() {
        List<Waggon> waggons = waggonService.getAllWaggons();
        ModelAndView modelAndView = new ModelAndView("listOfWaggons");
        modelAndView.addObject("waggon", waggons);
        return modelAndView;
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public ModelAndView addWaggonPage() {
        ModelAndView modelAndView = new ModelAndView("waggonForm");
        modelAndView.addObject("waggon", new Waggon());
        modelAndView.addObject("maps", mapService.getAllMap());
        return modelAndView;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ModelAndView addingWaggon(@ModelAttribute("waggon") Waggon waggon) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        waggonService.addWaggon(waggon);
        String message = "Waggon was successfully added";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editWaggonPage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("waggonEdit");
        Waggon waggon = waggonService.getWaggon(id);
        modelAndView.addObject("waggon", waggon);
        return modelAndView;
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editWaggon(@ModelAttribute Waggon waggon, @PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("waggonEdit");
        waggonService.updateWaggon(waggon);
        String message = "Waggon was successfully edited.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView removeWaggon(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        waggonService.removeWaggon(id);
        String message = "Waggon was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}
