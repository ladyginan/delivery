package com.app.service;

import com.app.model.WayPoint;

import java.util.List;

public interface WayPointServiceInterface {
    void addWayPoint(WayPoint wayPoint);

    List<WayPoint> getAllWayPoints();
}
