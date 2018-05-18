package com.app.service.impl;

import com.app.model.Map;
import com.app.repository.impl.MapRepository;
import com.app.service.MapServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class MapService implements MapServiceInterface {
    @Autowired
    private MapRepository mapRepository;

    @Override
    public List<Map> getAllMap() {
        return mapRepository.getAllMap();
    }

}
