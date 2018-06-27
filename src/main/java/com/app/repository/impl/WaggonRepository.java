package com.app.repository.impl;

import com.app.model.Waggon;
import com.app.repository.WaggonRepositoryInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class WaggonRepository implements WaggonRepositoryInterface {
    private final SessionFactory factory;
//show list of waggons

    @Override
    public List<Waggon> getAllWaggons() {
        List<Waggon> waggons = factory.getCurrentSession().createQuery("from Waggon").list();
        log.info("Waggon list is load form DB.");
        return waggons;
    }
// add new waggon

    @Override
    public void addWaggon(Waggon waggon) {
        factory.getCurrentSession().save(waggon);
        log.info("Waggon is saved.");
    }

    //remove waggon
    @Override
    public void removeWaggon(int id) {
        Waggon waggon = getWaggon(id);
        factory.getCurrentSession().delete(waggon);
        log.info("Waggon is deleted.");
    }

    //update waggon
    @Override
    public Waggon updateWaggon(Waggon waggon) {
        factory.getCurrentSession().update(waggon);
        log.info("Waggon is updated.");
        return factory.getCurrentSession().get(Waggon.class, waggon.getIdWaggon());
    }

    //get waggon
    @Override
    public Waggon getWaggon(int id) {
        Waggon waggon = (Waggon) factory.getCurrentSession().get(Waggon.class, id);
        log.info("Waggon is founded.");
        return waggon;
    }

    //get waggon by registration number
    @Override
    public Waggon getWaggonByRegNumber(String regNumber) {
        Waggon waggon = (Waggon) factory.getCurrentSession().get(Waggon.class, regNumber);
        log.info("Waggon is founded by registration number.");
        return waggon;
    }

    @Override
    public List<Waggon> getAllWorkingWaggon() {
        List<Waggon> waggons = factory.getCurrentSession().createQuery("from Waggon where status = :WORKING").list();
        log.info("All working waggons are load.");
        return waggons;
    }


}
