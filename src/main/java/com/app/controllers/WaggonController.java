package com.app.controllers;

import com.app.model.Waggon;
import com.app.model.WayPoint;
import com.app.service.MapServiceInterface;
import com.app.service.WaggonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/waggons")
public class WaggonController {
    @Autowired
    private WaggonServiceInterface waggonService;
    @Autowired
    private MapServiceInterface mapService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Waggon> getAllWaggonsJson() {
        List<Waggon> waggons = waggonService.getAllWaggons();
        return waggons;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ModelAndView getAllWaggon() {
        List<Waggon> waggons = waggonService.getAllWaggons();
        ModelAndView modelAndView = new ModelAndView("listOfWaggons");
        modelAndView.addObject("waggons", waggons);
        return modelAndView;
    }

    @GetMapping("/add")
    public String waggonForm(Model model) {
        model.addAttribute("waggon", new Waggon());
        model.addAttribute("maps", mapService.getAllMap());
        return "waggonForm";
    }

    @PostMapping("/add")
    public String waggonSubmit(@ModelAttribute Waggon waggon, Model model) {
        waggonService.addWaggon(waggon);
        String message = "Waggon was successfully added";
        model.addAttribute("message", message);
        return "welcome";
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
