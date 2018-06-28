package com.app.service.impl;

import com.app.model.Map;
import com.app.repository.MapRepositoryInterface;
import com.app.service.MapServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class MapService implements MapServiceInterface {
    @Autowired
    private MapRepositoryInterface mapRepository;

    @Transactional
    @Override
    public List<Map> getAllMap() {
        return mapRepository.getAllMap();
    }

    @Transactional
    @Override
    public Map findCityById(int id) {
        return mapRepository.findCityById(id);
    }

}
