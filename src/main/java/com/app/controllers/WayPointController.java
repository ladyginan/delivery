package com.app.controllers;
import com.app.model.Cargo;
import com.app.model.Map;
import com.app.model.WayPoint;
import com.app.service.CargoServiceInterface;
import com.app.service.MapServiceInterface;
import com.app.service.WayPointServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller @RequestMapping(path = "/points")
public class WayPointController {
    @Autowired
    private WayPointServiceInterface wayPointService;
    @Autowired
    private CargoServiceInterface cargoService;
    @Autowired
    private MapServiceInterface mapService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<WayPoint> getAllWaypoints() {
        List<WayPoint> wayPoints = wayPointService.getAllWayPoints();
        return wayPoints;
    }

    @GetMapping("/add")
    public String wayPointForm(Model model) {
        List<Cargo> cargoes = cargoService.getAllCargoes();
        List<Map> cities = mapService.getAllMap();
        model.addAttribute("cargoes",cargoes);
        model.addAttribute("cities", cities);
        model.addAttribute("wayPoint", new WayPoint());
        return "wayPointForm";
    }

    @PostMapping("/add")
    public String wayPointSubmit(@ModelAttribute WayPoint wayPoint, Model model) {
        wayPointService.addWayPoint(wayPoint);
        String message = "WayPoint was successfully added";
        model.addAttribute("message", message);
        return "welcome";
    }
}
