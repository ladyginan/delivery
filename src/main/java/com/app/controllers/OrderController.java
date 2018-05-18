package com.app.controllers;

import com.app.model.Order;
import com.app.service.CargoServiceInterface;
import com.app.service.MapServiceInterface;
import com.app.service.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/orders")
public class OrderController {
    @Autowired
    private OrderServiceInterface orderService;
    @Autowired
    private CargoServiceInterface cargoService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        ModelAndView modelAndView = new ModelAndView("listOfOrders");
        modelAndView.addObject("orders",orders);
        return  modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addOrderPage(){
        ModelAndView modelAndView = new ModelAndView("orderForm");
        modelAndView.addObject("order", new Order());
        modelAndView.addObject("cargo", cargoService.getAllCargoes());
        return modelAndView;
    }
}
