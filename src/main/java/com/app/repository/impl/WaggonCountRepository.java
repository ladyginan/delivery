package com.app.repository.impl;

import com.app.model.Driver;
import com.app.model.Waggon;
import com.app.repository.DriversRepositoryInterface;
import com.app.repository.WaggonCountRepositoryInterface;
import com.app.repository.WaggonRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

import static com.app.model.Enums.WaggonStatus.BROKEN;
import static com.app.model.Enums.WaggonStatus.WORKING;
@Slf4j
@Repository
public class WaggonCountRepository implements WaggonCountRepositoryInterface {

    @Autowired
    private final SessionFactory factory;
    @Autowired
    private WaggonRepositoryInterface waggonRepository;
    @Autowired
    private DriversRepositoryInterface driversRepository;

    public WaggonCountRepository(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public int getAllWaggonsCount() {
        List<Waggon> list = waggonRepository.getAllWaggons();
        int count = list.size();
        return count;
    }

    @Override
    public int getAllBusyWaggon() {
        List<Driver> list = driversRepository.getAllDrivers();
        int count = 0;
        for(Driver driver : list){
            if(driver.getWaggon() != null){
                count++;
            }
        }
        return count;
    }

    @Override
    public int getAllFreeWaggonsCount() {
        List<Driver> list = driversRepository.getAllDrivers();
        int count = 0;
        for(Driver driver : list){
            if(driver.getWaggon() != null){
                count++;
            }
        }
        count = getAllWaggonsCount() - getAllBusyWaggon();
        return count;
    }

    @Override
    public int getAllWorkingWaggon() {
        Query query = factory.getCurrentSession().createQuery("Select W from Waggon W where W.status = :WORKING");
        query.setParameter("WORKING", WORKING);
        List<Waggon> waggons = ((org.hibernate.query.Query) query).list();
        return waggons.size();
    }

    @Override
    public int getAllBrokenWaggon() {
        Query query = factory.getCurrentSession().createQuery("Select W from Waggon W where W.status = :BROKEN");
        query.setParameter("BROKEN", BROKEN);
        List<Waggon> waggons = ((org.hibernate.query.Query) query).list();
        return waggons.size();
    }
}
