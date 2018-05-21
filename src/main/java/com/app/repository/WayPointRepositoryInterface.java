package com.app.repository;

import com.app.model.WayPoint;

import java.util.List;

public interface WayPointRepositoryInterface {
    void addWayPoint(WayPoint wayPoint);

    List<WayPoint> getAllWayPoints();
}
