package com.app.controllers;

import com.app.DTO.WaggonDTO;
import com.app.model.Waggon;
import com.app.service.MapServiceInterface;
import com.app.service.WaggonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @ResponseBody
    public List<WaggonDTO> getAllWaggonsJson() {
        List<WaggonDTO> waggons = waggonService.getAllWaggons();
        return waggons;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public WaggonDTO editWaggon(@RequestBody WaggonDTO waggonDTO) {
        System.out.println(waggonDTO);
        waggonService.updateWaggon(waggonDTO);
        return new WaggonDTO();
    }


    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ModelAndView getAllWaggon() {
        List<WaggonDTO> waggons = waggonService.getAllWaggons();
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
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    WaggonDTO getWaggonById(@PathVariable int id) {
        WaggonDTO waggonDTO = waggonService.getWaggonDTO(id);
        return waggonDTO;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public @ResponseBody
    WaggonDTO editWaggon(@RequestBody WaggonDTO waggonDTO, @PathVariable int id) {
        WaggonDTO savedWaggon = waggonService.updateWaggon(waggonDTO);
        return savedWaggon;
    }


    @RequestMapping(path = "/edit/success", method = RequestMethod.GET)
    public ModelAndView editWaggonSuccessMessage() {
        ModelAndView modelAndView = new ModelAndView("welcome");
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
