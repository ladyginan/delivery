package com.app.coverters;

import com.app.service.MapServiceInterface;
import org.springframework.stereotype.Component;
import com.app.model.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


@Component
public class CityConverter implements Converter<Object, Map> {

    @Autowired
    private MapServiceInterface mapService;

    @Override
    public Map convert(Object source) {
        Integer id = Integer.parseInt((String)source);
        Map city = mapService.findCityById(id);
        return city;
    }
}