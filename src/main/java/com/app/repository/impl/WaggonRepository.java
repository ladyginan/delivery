package com.app.repository.impl;

import com.app.model.Waggon;
import com.app.repository.WaggonRepositoryInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class WaggonRepository implements WaggonRepositoryInterface {
    @Autowired
    private final SessionFactory factory;

    public WaggonRepository(SessionFactory factory) {
        this.factory = factory;
    }

    @Transactional
    @Override
    public List<Waggon> getAllWaggons() {
        List<Waggon> waggons = factory.getCurrentSession().createQuery("from Waggon").list();
        return waggons;
    }

    @Override
    public void addWaggon(Waggon waggon) {
        factory.getCurrentSession().save(waggon);
    }

    @Override
    public void removeWaggon(String id) {
        factory.getCurrentSession().createQuery("Delete Waggon from WAGGONS where ID_WAGGON = 'id'");
    }

    @Override
    public void updateWaggon(Waggon waggon) {
        Waggon WaggonToUpdate = getWaggon(waggon.getIdWaggon());
        WaggonToUpdate.setIdWaggon(waggon.getIdWaggon());
        WaggonToUpdate.setShiftSize(waggon.getShiftSize());
        WaggonToUpdate.setCapacity(waggon.getCapacity());
        WaggonToUpdate.setStatus(waggon.getStatus());
        WaggonToUpdate.setCurrentCity(waggon.getCurrentCity());
        factory.getCurrentSession().update(WaggonToUpdate);
    }

    @Override
    public Waggon getWaggon(String id) {
        Waggon waggon = (Waggon) factory.getCurrentSession().get(Waggon.class, id);
        return waggon;
    }
}
