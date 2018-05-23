package com.app.controllers;

import com.app.model.Order;
import com.app.service.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/status")
public class OrderStatusController {
    @Autowired
    private OrderServiceInterface orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView getAllDrivers() {
        List<Order> orders = orderService.getAllOrders();
        ModelAndView modelAndView = new ModelAndView("orderStatus");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }
}
