package com.app.repository;

import com.app.model.Order;
import com.app.model.WayPoint;

import java.util.List;

public interface WayPointOrderRepositoryInterface {
    public List<WayPoint> getAllWayPointsOfOrder(Order order);
}
