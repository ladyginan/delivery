package com.app.repository.impl;

import com.app.model.Driver;
import com.app.model.Order;
import com.app.model.WayPoint;
import com.app.repository.OrderRepositoryInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
@AllArgsConstructor
public class OrderRepository implements OrderRepositoryInterface {
    private final SessionFactory factory;
    //show list of orders

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = factory.getCurrentSession().createQuery("from Order").list();
        log.info("All orders are load.");
        return orders;
    }

    //add new order

    @Override
    public Order addOrder(Order order) {
        Integer savedOrderId = (Integer) factory.getCurrentSession().save(order);
        Order savedOrder = (Order) factory.getCurrentSession().get(Order.class, savedOrderId);
        log.info("Order is saved.");
        return savedOrder;
    }

    public void settingOrderIdInWayPointsAndDrivers(List<Integer> points, List<Integer> drivers, Order order) {
        for (Integer pointId : points) {
            WayPoint point = factory.getCurrentSession().get(WayPoint.class, pointId);
            point.setOrder(order);
            factory.getCurrentSession().update(point);

        }

        for (Integer driverId : drivers) {
            Driver driver = factory.getCurrentSession().get(Driver.class, driverId);
            driver.setOrder(order);
            factory.getCurrentSession().update(driver);
        }
        log.info("Order waypoints and drivers are set.");
    }

    @Override
    public Order getOrderById(int id) {
        Order order = (Order) factory.getCurrentSession().get(Order.class, id);
        log.info("Order is found.");
        return order;
    }

}

