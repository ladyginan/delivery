package com.app.controllers;

import com.app.DTO.CreateOrderDTO;
import com.app.DTO.OrderDTO;
import com.app.configuration.rabbitMq.Producer;
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
    private DriverServiceInterface driverService;
    @Autowired
    private OrderServiceInterface orderService;
    @Autowired
    private Producer producer;
    @Autowired
    private OrderJsonServiceInterface orderJsonService;
    @Autowired
    private DriverJsonServiceInterface driverJsonService;
    @Autowired
    private WaggonJsonServiceInterface waggonJsonService;


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Order createOrder(@RequestBody CreateOrderDTO createOrderDTO) {
        System.out.println(createOrderDTO);
        Order order = orderService.createOrder(createOrderDTO);
        producer.sendMessage(orderJsonService.getNewOrderJson(order));
        producer.sendMessageDrivers(driverJsonService.getDriverJson());
        producer.sendMessageWaggons(waggonJsonService.getWaggonJson());
        return new Order();
    }

    @GetMapping("/add")
    public String orderForm(Model model) {
        return "orderForm";
    }

    @PostMapping("/add")
    public String orderSubmit(@ModelAttribute OrderDTO orderDTO, Model model) {
        String message = "Order was successfully added";
        model.addAttribute("message", message);
        return "welcome";
    }

    @RequestMapping(value = "/add/success", method = RequestMethod.GET)
    public ModelAndView editOrderSuccessMessage() {
        ModelAndView modelAndView = new ModelAndView("listOfOrders");
        String message = "Order was successfully edited.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        ModelAndView modelAndView = new ModelAndView("listOfOrders");
        modelAndView.addObject("waggons", waggonService.getAllWaggons());
        modelAndView.addObject("pointList", wayPointService.getAllWayPoints());
        modelAndView.addObject("drivers", driverService.getAllDrivers());
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

}
