package com.app.service;

import com.app.configuration.rabbitMq.OrderJson;
import com.app.model.Driver;
import com.app.model.Order;
import com.app.model.WayPoint;

import java.util.List;

public interface OrderJsonServiceInterface {

    OrderJson getNewOrderJson(Order order);

    public List<OrderJson> getAllOrdersJson();

    public List<String> getAllDriversOrder(List<Driver> drivers);

    public List<String> getAllWayPointsOrder(List<WayPoint> wayPoints);

}
