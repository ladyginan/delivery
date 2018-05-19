package com.app.repository;

import com.app.model.Order;

import java.util.List;

public interface OrderRepositoryInterface {
    List<Order> getAllOrders();

    void addOrder(Order order);
}
