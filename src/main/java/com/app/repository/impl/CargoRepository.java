package com.app.repository.impl;

import com.app.model.Cargo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CargoRepository {
    @Autowired
    private final SessionFactory factory;

    public CargoRepository(SessionFactory factory) {
        this.factory = factory;
    }


    //show cargoes list
    public List<Cargo> getAllCargos() {
        List<Cargo> cargoes = factory.getCurrentSession().createQuery("from Cargo").list();
        return cargoes;
    }
    //add new cargo
    public void addCargo(Cargo cargo) {
        factory.getCurrentSession().save(cargo);
    }


}
