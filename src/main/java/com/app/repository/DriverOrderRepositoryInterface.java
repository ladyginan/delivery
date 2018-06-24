package com.app.repository;

import com.app.model.Driver;
import com.app.model.Order;

import java.util.List;

public interface DriverOrderRepositoryInterface {
    List<Driver> getAllDriversOfOrder(Order order);
}
