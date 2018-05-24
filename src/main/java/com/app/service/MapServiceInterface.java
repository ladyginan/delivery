package com.app.service;

import com.app.model.Map;

import java.util.List;

public interface MapServiceInterface {
    List<Map> getAllMap();

    Map findCityById(int id);
}
