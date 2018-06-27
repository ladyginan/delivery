package com.app.repository.impl;

import com.app.model.WayPoint;
import com.app.repository.WayPointRepositoryInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
@AllArgsConstructor
public class WayPointRepository implements WayPointRepositoryInterface {
    private final SessionFactory factory;

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
