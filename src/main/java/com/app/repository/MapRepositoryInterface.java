package com.app.repository;

import com.app.model.Map;

import java.util.List;

public interface MapRepositoryInterface {
    List<Map> getAllMap();

    Map findCityById(int id);
}
