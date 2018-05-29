package com.app.coverters;

import com.app.model.Cargo;
import com.app.service.CargoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CargoConverter implements Converter<Object, Cargo> {
    @Autowired
    CargoServiceInterface cargoService;

    @Override
    public Cargo convert(Object source) {
        Integer id = Integer.parseInt((String) source);
        Cargo cargo = cargoService.getCargo(id);
        return cargo;
    }
}
