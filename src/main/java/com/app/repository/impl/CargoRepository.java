package com.app.repository.impl;

import com.app.model.Cargo;
import com.app.repository.CargoRepositoryInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class CargoRepository implements CargoRepositoryInterface {
    @Autowired
    private final SessionFactory factory;
    private static Logger log = Logger.getLogger(CargoRepository.class.getName());

    public CargoRepository(SessionFactory factory) {
        this.factory = factory;
    }

    //show cargoes list

    @Override
    public List<Cargo> getAllCargoes() {
        List<Cargo> cargoes = factory.getCurrentSession().createQuery("from Cargo").list();
        return cargoes;
    }

    //get cargo by id
    @Override
    public Cargo getCargo(int id) {
        Cargo cargo = factory.getCurrentSession().get(Cargo.class, id);
        return cargo;
    }

    //add new cargo
    @Override
    public void addCargo(Cargo cargo) {
        factory.getCurrentSession().save(cargo);
    }


}
