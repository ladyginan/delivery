package com.app.service.impl;

import com.app.configuration.rabbitMq.WaggonJson;
import com.app.repository.WaggonCountRepositoryInterface;
import com.app.service.WaggonJsonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class WaggonJsonService implements WaggonJsonServiceInterface {

    @Autowired
    WaggonCountRepositoryInterface waggonCountRepository;

    @Transactional
    @Override
    public int getAllWaggonCount() {
        int count = waggonCountRepository.getAllWaggonsCount();
        return count;
    }
    @Transactional
    @Override
    public int getAllFreeWaggonCount() {
        int count = waggonCountRepository.getAllFreeWaggonsCount();
        return count;
    }
    @Transactional
    @Override
    public int getAllBusyWaggonCount() {
        int count = waggonCountRepository.getAllBusyWaggon();
        return count;
    }
    @Transactional
    @Override
    public int getAllWorkingWaggonCount() {
        int count = waggonCountRepository.getAllWorkingWaggon();
        return count;
    }
    @Transactional
    @Override
    public int getAllBrokenWaggonCount() {
        int count = waggonCountRepository.getAllBrokenWaggon();
        return count;
    }
    @Transactional
    @Override
    public WaggonJson getWaggonJson() {
        WaggonJson waggonJson =
                new WaggonJson(getAllWaggonCount(),
                getAllFreeWaggonCount(),
                getAllBusyWaggonCount(),
                getAllWorkingWaggonCount(),
                getAllBrokenWaggonCount());
        return waggonJson;
    }
}
