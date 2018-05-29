package com.app.repository.impl;

import com.app.model.Waggon;
import com.app.repository.WaggonRepositoryInterface;
import com.app.service.impl.WaggonService;
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
//show list of waggons

    @Override
    public List<Waggon> getAllWaggons() {
        List<Waggon> waggons = factory.getCurrentSession().createQuery("from Waggon").list();
        return waggons;
    }
// add new waggon

    @Override
    public void addWaggon(Waggon waggon) {
        factory.getCurrentSession().save(waggon);
    }
//remove waggon
    @Override
    public void removeWaggon(int id) {
        Waggon waggon = getWaggon(id);
        factory.getCurrentSession().delete(waggon);
    }
//update waggon
    @Override
    public Waggon updateWaggon(Waggon waggon) {
        factory.getCurrentSession().update(waggon);
        return factory.getCurrentSession().get(Waggon.class, waggon.getIdWaggon());
    }
//get waggon
    @Override
    public Waggon getWaggon(int id) {
        Waggon waggon = (Waggon) factory.getCurrentSession().get(Waggon.class, id);
        return waggon;
    }
//get waggon by registration number
    @Override
    public Waggon getWaggonByRegNumber(String regNumber) {
        Waggon waggon = (Waggon) factory.getCurrentSession().get(Waggon.class, regNumber);
        return waggon;
    }

}
