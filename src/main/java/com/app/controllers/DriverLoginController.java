//package com.app.controllers;
//
//import com.app.model.Driver;
//import com.app.service.DriverServiceInterface;
//import com.app.service.MapServiceInterface;
//import com.app.service.WaggonServiceInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping(path = "/driverPanel")
//public class DriverLoginController {
//    @Autowired
//    private DriverServiceInterface driverService;
//    @Autowired
//    private WaggonServiceInterface waggonService;
//    @Autowired
//    private MapServiceInterface mapService;
//
//    @RequestMapping(path = "/userPage")
//    public ModelAndView driverLoginForm() {
//        ModelAndView modelAndView = new ModelAndView("driverLogin");
//        modelAndView.addObject("driver", new Driver());
//        modelAndView.addObject("waggons", waggonService.getAllWaggons());
//        modelAndView.addObject("maps", mapService.getAllMap());
//        return modelAndView;
//    }
//
//
//}
