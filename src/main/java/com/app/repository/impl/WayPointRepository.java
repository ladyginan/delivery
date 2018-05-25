package com.app.repository.impl;

import com.app.model.WayPoint;
import com.app.repository.WayPointRepositoryInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class WayPointRepository implements WayPointRepositoryInterface {
    @Autowired
    private final SessionFactory factory;

    public WayPointRepository(SessionFactory factory) {
        this.factory = factory;
    }
//add new way point
    @Override
    public void addWayPoint(WayPoint wayPoint) {
        factory.getCurrentSession().save(wayPoint);
    }
//return list of way points
    @Override
    public List<WayPoint> getAllWayPoints() {
        List<WayPoint> wayPoints = factory.getCurrentSession().createQuery("from WayPoint").list();
        return wayPoints;
    }
//find way point by id
    @Override
    public WayPoint findWayPointById(int id) {
        WayPoint wayPoint = (WayPoint) factory.getCurrentSession().get(WayPoint.class, id);
        return wayPoint;
    }
}
