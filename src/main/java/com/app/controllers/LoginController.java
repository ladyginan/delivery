package com.app.controllers;

import com.app.DTO.DriverDTO;
import com.app.model.Driver;
import com.app.service.UserDriverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private UserDriverServiceInterface userDriverService;

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean hasUserRole = auth.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_DRIVER"));
        if(hasUserRole){
            DriverDTO driverDTO  = userDriverService.findDriverIdByUsername(principal.getName());
            int id = driverDTO.getIdDriver();
            if (id == -1){
                return "driverLogin";
            }else{
                model.addAttribute("message", "You are logged in as " + principal.getName());
                return "driverInfo";
            }
        }
        model.addAttribute("message", "You are logged in as " + principal.getName());
        return "welcome";
    }
}