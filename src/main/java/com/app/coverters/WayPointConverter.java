package com.app.coverters;

import com.app.model.WayPoint;
import com.app.service.WayPointServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WayPointConverter implements Converter<Object, WayPoint> {

    @Autowired
    private WayPointServiceInterface wayPointService;

    @Override
    public WayPoint convert(Object source) {
        Integer id = Integer.parseInt((String)source);
        WayPoint wayPoint = wayPointService.findWayPointById(id);
        return wayPoint;
    }
}
