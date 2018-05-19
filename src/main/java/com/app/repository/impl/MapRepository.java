package com.app.repository.impl;

import com.app.model.Map;
import com.app.repository.MapRepositoryInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapRepository implements MapRepositoryInterface {
    @Autowired
    private final SessionFactory factory;

    public MapRepository(SessionFactory factory) {
        this.factory = factory;
    }

    public void addMap() {
        factory.getCurrentSession().save(new Map("Санкт-Петербург", 59.938806, 30.314278));
        factory.getCurrentSession().save(new Map("Москва", 55.755773, 37.617761));
        factory.getCurrentSession().save(new Map("Воронеж", 51.661535, 39.200287));
        factory.getCurrentSession().save(new Map("Архангельск", 64.539304, 40.518735));
        factory.getCurrentSession().save(new Map("Екатеринбург", 56.838002, 60.597295));
        factory.getCurrentSession().save(new Map("Москва", 55.755773, 37.617761));
        factory.getCurrentSession().save(new Map("Мурманск", 68.96956299999999, 33.07454));
        factory.getCurrentSession().save(new Map("Пермь", 58.004785, 56.237654));
        factory.getCurrentSession().save(new Map("Тверь", 56.859611, 35.911896));
        factory.getCurrentSession().save(new Map("Хабаровск", 48.472584, 135.057732));
    }

    @Override
    public List<Map> getAllMap() {
        List<Map> map = factory.getCurrentSession().createQuery("from Map").list();
        return map;
    }


}
