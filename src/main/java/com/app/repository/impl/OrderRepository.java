package com.app.repository.impl;

import com.app.model.Driver;
import com.app.model.Order;
import com.app.model.WayPoint;
import com.app.repository.OrderRepositoryInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository implements OrderRepositoryInterface {
    @Autowired
    private final SessionFactory factory;

    public OrderRepository(SessionFactory factory) {
        this.factory = factory;
    }

    //show list of orders

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = factory.getCurrentSession().createQuery("from Order").list();
        return orders;
    }

    //add new order

    @Override
    public Order addOrder(Order order) {
        Integer savedOrderId = (Integer) factory.getCurrentSession().save(order);
        Order savedOrder = (Order) factory.getCurrentSession().get(Order.class, savedOrderId);
        return savedOrder;
    }

    public void settingOrderIdInWayPointsAndDrivers(List<Integer> points, List<Integer> drivers, Order order){
        for (Integer pointId : points) {
        WayPoint point = factory.getCurrentSession().get(WayPoint.class, pointId);
        point.setOrder(order);
        factory.getCurrentSession().update(point);
        }

        for (Integer driverId : drivers) {
        Driver driver = factory.getCurrentSession().get(Driver.class,driverId);
        driver.setOrder(order);
        factory.getCurrentSession().update(driver);
        }
    }
}

