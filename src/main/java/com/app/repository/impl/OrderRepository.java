package com.app.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    @Autowired
    private final SessionFactory factory;

    public OrderRepository(SessionFactory factory) {
        this.factory = factory;
    }
}
