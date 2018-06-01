package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(path = "/driverPanel")
public class LoginController {

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        if(principal.getName().equals("driver")){
            return "driverInfo";
        }
        model.addAttribute("message", "You are logged in as " + principal.getName());
        return "welcome";
    }
}