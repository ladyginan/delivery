package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {

    @RequestMapping(value="/")
    public ModelAndView mainPage() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value="/index")
    public ModelAndView indexPage() {
        return new ModelAndView("welcome");
    }
}