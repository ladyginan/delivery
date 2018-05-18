package com.app.repository.impl;

import com.app.model.WayPoint;
import com.app.repository.WayPointRepositoryInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WayPointRepository implements WayPointRepositoryInterface {
    @Autowired
    private final SessionFactory factory;

    public WayPointRepository(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void addWayPoint(WayPoint wayPoint) {
        factory.getCurrentSession().save(wayPoint);
    }
}
