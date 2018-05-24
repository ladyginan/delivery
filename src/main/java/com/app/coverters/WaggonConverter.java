package com.app.coverters;

import com.app.model.Waggon;
import com.app.service.WaggonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WaggonConverter implements Converter<Object, Waggon> {
    @Autowired
    WaggonServiceInterface waggonService;
    @Override

    public Waggon convert(Object source) {
        Integer id = Integer.parseInt((String)source);
        Waggon waggon = waggonService.getWaggon(id);
        return waggon;
    }
}
