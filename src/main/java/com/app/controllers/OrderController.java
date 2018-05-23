package com.app.controllers;

import com.app.DTO.OrderDTO;
import com.app.model.Cargo;
import com.app.model.Map;
import com.app.model.Order;
import com.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping(path = "/orders")
public class OrderController {
    @Autowired
    private WayPointServiceInterface wayPointService;
    @Autowired
    private WaggonServiceInterface waggonService;
    @Autowired
    private DriverServiceInterface driverServiceInterface;
    @Autowired
    private OrderServiceInterface orderService;

//    @RequestMapping(path = "/ajax")
//    public ModelAndView mainPage() {
//        return new ModelAndView("orderForm");
//    }

//    @RequestMapping(method = RequestMethod.GET, path = "/ajax/json")
//    public @ResponseBody
//    List<Map> ajaxCities(){
//        List<Map> cities = mapService.getAllMap();
//        return cities;
//    }
//    @RequestMapping(method = RequestMethod.GET, path = "/ajax/jsonCargo")
//    public @ResponseBody
//    List<Cargo> ajaxCargo(){
//        List<Cargo> cargoes = cargoService.getAllCargoes();
//        return cargoes;
//    }

    @GetMapping("/add")
    public String waggonForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("wayPoints", wayPointService.getAllWayPoints());
        model.addAttribute("drivers", driverServiceInterface.getAllDrivers());
        return "orderForm";
    }

    @PostMapping("/add")
    public String waggonSubmit(@ModelAttribute OrderDTO orderDTO, Model model) {
        orderService.addOrder(orderDTO);
        String message = "Order was successfully added";
        model.addAttribute("message", message);
        return "welcome";
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



}
