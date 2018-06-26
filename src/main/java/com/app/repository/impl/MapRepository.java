package com.app.repository.impl;

import com.app.model.Map;
import com.app.repository.MapRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
public class MapRepository implements MapRepositoryInterface {
    @Autowired
    private final SessionFactory factory;

    public MapRepository(SessionFactory factory) {
        this.factory = factory;
    }

    //show list of cities

    @Override
    public List<Map> getAllMap() {
        List<Map> map = factory.getCurrentSession().createQuery("from Map").list();
        return map;
    }
    // find city by id

    @Override
    public Map findCityById(int id) {
        return factory.getCurrentSession().get(Map.class, id);
    }


}
