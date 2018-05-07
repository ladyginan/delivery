package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerHello {
    @RequestMapping("/welcome.jsp")public ModelAndView helloWorld() {

        String message = "Hello!";
        return new ModelAndView("welcome", "message", message);
    }
}
