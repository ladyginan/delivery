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

    @Transactional
    @Override
    public void addWaggon(Waggon waggon) {
        factory.getCurrentSession().save(waggon);
    }

    @Transactional
    @Override
    public void removeWaggon(int id) {
        factory.getCurrentSession().createQuery("Delete Waggon from WAGGONS where ID_WAGGON = 'id'");
    }

    @Transactional
    @Override
    public void updateWaggon(Waggon waggon) {
        Waggon WaggonToUpdate = getWaggon(waggon.getIdWaggon());
        WaggonToUpdate.setIdWaggon(waggon.getIdWaggon());
        WaggonToUpdate.setRegNumber(waggon.getRegNumber());
        WaggonToUpdate.setShiftSize(waggon.getShiftSize());
        WaggonToUpdate.setCapacity(waggon.getCapacity());
        WaggonToUpdate.setStatus(waggon.getStatus());
        WaggonToUpdate.setCity(waggon.getCity());
        factory.getCurrentSession().update(WaggonToUpdate);
    }

    @Transactional
    @Override
    public Waggon getWaggon(int id) {
        Waggon waggon = (Waggon) factory.getCurrentSession().get(Waggon.class, id);
        return waggon;
    }
}
