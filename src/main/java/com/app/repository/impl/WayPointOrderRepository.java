package com.app.repository.impl;

import com.app.model.Order;
import com.app.model.WayPoint;
import com.app.repository.WayPointOrderRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Slf4j
@Repository
public class WayPointOrderRepository implements WayPointOrderRepositoryInterface {
    @Autowired
    private final SessionFactory factory;

        public WayPointOrderRepository(SessionFactory factory) {
            this.factory = factory;
        }


        @Override
        public List<WayPoint> getAllWayPointsOfOrder(Order order) {
            Query query = factory.getCurrentSession().createQuery("Select W from WayPoint W where W.order = :order");
            query.setParameter("order", order);
            List<WayPoint> wayPoints = ((org.hibernate.query.Query) query).list();
            return wayPoints;
        }
}