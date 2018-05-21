package com.app.controllers;

import com.app.model.Cargo;
import com.app.model.Order;
import com.app.model.Waggon;
import com.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    @Autowired
    private OrderServiceInterface orderService;
   @Autowired
   private WayPointServiceInterface wayPointService;
    @Autowired
    private WaggonServiceInterface waggonService;
    @Autowired
    private DriverServiceInterface driverService;



    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        ModelAndView modelAndView = new ModelAndView("listOfOrders");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @GetMapping("/add")
    public String waggonForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("wayPoints", wayPointService.getAllWayPoints());
        model.addAttribute("waggons", waggonService.getAllWaggons());
        return "orderForm";
    }
    @PostMapping("/add")
    public String waggonSubmit(@ModelAttribute Order order, Model model) {
        model.addAttribute("order", order);
        String message = "Cargo was successfully added";
        model.addAttribute("message", message);
        return "welcome";
    }


}
