package com.app.controllers;

import com.app.DTO.DriverDTO;
import com.app.service.SendJsonOrdersInterface;
import com.app.service.UserDriverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
public class UserDriverController {
    @Autowired
    private UserDriverServiceInterface userDriverService;
    //check Role for redirect
    @GetMapping("/")
    public String index(Model model, Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int id;
        boolean hasUserRole = auth.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_DRIVER"));
        // This is method for checking userDriver existence.
        if (hasUserRole) {
            DriverDTO driverDTO = userDriverService.findDriverIdByUsername(principal.getName());
            id = driverDTO.getIdDriver();
            if (id == -1) {
                return "driverLogin"; //select driver
            } else {
                model.addAttribute("message", "You are logged in as " + principal.getName());
                model.addAttribute("driverID", id);
                return "welcomeDriverPage"; //start working with personal info
            }
        }
        model.addAttribute("message", "You are logged in as " + principal.getName());
        return "welcome"; //login as manager or admin
    }
}