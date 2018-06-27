package com.app.repository.impl;

import com.app.model.Cargo;
import com.app.repository.CargoRepositoryInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.QueryException;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@Slf4j
@Repository
@AllArgsConstructor
public class CargoRepository implements CargoRepositoryInterface {
    private final SessionFactory factory;
    //show cargoes list

    @Override
    public List<Cargo> getAllCargoes() {
        List<Cargo> cargoes = factory.getCurrentSession().createQuery("from Cargo").list();
        log.info("Cargoes list was load form DB.");
        return cargoes;
    }

    @Override
    public Cargo updateCargo(Cargo cargo) {
        factory.getCurrentSession().update(cargo);
        return factory.getCurrentSession().get(Cargo.class, cargo.getIdCargo());
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
