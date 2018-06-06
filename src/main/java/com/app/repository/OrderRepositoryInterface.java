package com.app.repository;

import com.app.model.Order;

import java.util.List;

public interface OrderRepositoryInterface {
    List<Order> getAllOrders();

    Order addOrder(Order order);

    void settingOrderIdInWayPointsAndDrivers(List<Integer> points, List<Integer> drivers, Order order);

    Order getOrderById(int id);
}
