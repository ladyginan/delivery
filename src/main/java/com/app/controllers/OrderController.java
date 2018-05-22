package com.app.controllers;

import com.app.model.Cargo;
import com.app.model.Map;
import com.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class OrderController {
    @Autowired
    private MapServiceInterface mapService;
    @Autowired
    private CargoServiceInterface cargoService;

    @RequestMapping(path = "/ajax")
    public ModelAndView mainPage() {
        return new ModelAndView("orderForm");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ajax/json")
    public @ResponseBody
    List<Map> ajaxCities(){
        List<Map> cities = mapService.getAllMap();
        return cities;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/ajax/jsonCargo")
    public @ResponseBody
    List<Cargo> ajaxCargo(){
        List<Cargo> cargoes = cargoService.getAllCargoes();
        return cargoes;
    }



//
//
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public ModelAndView getAllOrders() {
//        List<Order> orders = orderService.getAllOrders();
//        ModelAndView modelAndView = new ModelAndView("listOfOrders");
//        modelAndView.addObject("orders", orders);
//        return modelAndView;
//    }


//    @PostMapping("/add")
//    public String waggonSubmit(@ModelAttribute Order order, Model model) {
//        model.addAttribute("order", order);
//        String message = "Cargo was successfully added";
//        model.addAttribute("message", message);
//        return "welcome";
//    }
}
