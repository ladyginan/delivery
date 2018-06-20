package com.app.repository;

import com.app.model.Driver;
import com.app.model.Order;
import com.app.model.WayPoint;

import java.util.List;

public interface DriverOrderRepositoryInterface {
    List<Driver> getAllDriversOfOrder(Order order);
}
