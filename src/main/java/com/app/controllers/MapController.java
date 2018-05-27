package com.app.controllers;

import com.app.model.Map;
import com.app.service.MapServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "cities")
public class MapController {
    @Autowired
    private MapServiceInterface mapService;
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Map> getAllMapsJson() {
        List<Map> cities = mapService.getAllMap();
        return cities;
    }
}
