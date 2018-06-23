package com.app.service;

import com.app.DTO.CreateOrderDTO;
import com.app.configuration.rabbitMq.OrderJson;
import com.app.model.Order;

import java.util.List;

public interface OrderServiceInterface {
    List<Order> getAllOrders();

//    void addOrder(OrderDTO orderDTO);

    Order createOrder(CreateOrderDTO createOrderDTO);

}
