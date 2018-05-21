package com.app.repository.impl;

import com.app.model.Map;
import com.app.repository.MapRepositoryInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MapRepository implements MapRepositoryInterface {
    @Autowired
    private final SessionFactory factory;

    public MapRepository(SessionFactory factory) {
        this.factory = factory;
    }

    @Transactional
    @Override
    public List<Map> getAllMap() {
        List<Map> map = factory.getCurrentSession().createQuery("from Map").list();
        return map;
    }
    @Transactional
    @Override
    public Map findCityById(int id) {
        return factory.getCurrentSession().get(Map.class, id);
    }


}
