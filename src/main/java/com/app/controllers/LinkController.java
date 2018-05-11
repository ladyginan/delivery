package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {

    @RequestMapping(path = "/")
    public ModelAndView mainPage() {
        return new ModelAndView("welcome");
    }

}