package com.app.service.impl;

import com.app.DTO.UserDriverDTO;
import com.app.model.UserDriver;
import com.app.repository.UserDriverRepositoryInterface;
import com.app.service.UserDriverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserDriverService implements UserDriverServiceInterface {
    @Autowired
    private UserDriverRepositoryInterface userDriverRepository;




    @Override
    public UserDriver createUserDriver(UserDriverDTO userDriverDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDriver userDriver = new UserDriver(auth.getName(),userDriverDTO.getIdDriver());
        userDriver = userDriverRepository.createUserDriver(userDriver);
        return userDriver;
    }
}
