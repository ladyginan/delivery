package com.app.repository.impl;

import com.app.model.Order;
import com.app.repository.OrderRepositoryInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OrderRepository implements OrderRepositoryInterface {
    @Autowired
    private final SessionFactory factory;

    public OrderRepository(SessionFactory factory) {
        this.factory = factory;
    }

    //show list of orders
    @Transactional
    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = factory.getCurrentSession().createQuery("from Order").list();
        return orders;
    }

    //add new order
    @Transactional
    @Override
    public Order addOrder(Order order) {
        Integer savedOrderId = (Integer) factory.getCurrentSession().save(order);
        Order savedOrder = (Order) factory.getCurrentSession().get(Order.class, savedOrderId);
        return savedOrder;
    }
}
