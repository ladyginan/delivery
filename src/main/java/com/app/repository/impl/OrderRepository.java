package com.app.repository.impl;

import com.app.model.Order;
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

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = factory.getCurrentSession().createQuery("from Order").list();
        return orders;
    }

    @Override
    public void addOrder(Order order) {
        factory.getCurrentSession().save(order);
    }
}
