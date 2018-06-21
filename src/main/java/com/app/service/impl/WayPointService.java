package com.app.service.impl;

import com.app.model.WayPoint;
import com.app.repository.WayPointRepositoryInterface;
import com.app.service.WayPointServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WayPointService implements WayPointServiceInterface {
    @Autowired
    private WayPointRepositoryInterface wayPointRepository;

    @Transactional
    @Override
    public void addWayPoint(WayPoint wayPoint) {
        wayPointRepository.addWayPoint(wayPoint);
    }

    @Transactional
    @Override
    public List<WayPoint> getAllWayPoints() {
        return wayPointRepository.getAllWayPoints();
    }


}
