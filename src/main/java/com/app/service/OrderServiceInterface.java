package com.app.service;

import com.app.DTO.OrderDTO;
import com.app.model.Order;

import java.util.List;

public interface OrderServiceInterface {
    List<Order> getAllOrders();

    void addOrder(OrderDTO orderDTO);


}
