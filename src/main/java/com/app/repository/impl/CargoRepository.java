package com.app.repository.impl;

import com.app.model.Cargo;
import com.app.repository.CargoRepositoryInterface;
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
public class CargoRepository implements CargoRepositoryInterface {
    @Autowired
    private final SessionFactory factory;

    public CargoRepository(SessionFactory factory) {
        this.factory = factory;
    }

    //show cargoes list

    @Override
    public List<Cargo> getAllCargoes() {
       try{
           List<Cargo> cargoes = factory.getCurrentSession().createQuery("from Cargo").list();
            log.info("Return list of cargoes");
            return cargoes;
       }catch(QueryException e){
           e.printStackTrace();
           log.error("get all Cargo error");
           return null;
       }
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
