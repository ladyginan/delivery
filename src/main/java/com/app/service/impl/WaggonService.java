package com.app.service.impl;

import com.app.model.Waggon;
import com.app.repository.WaggonRepositoryInterface;
import com.app.service.WaggonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WaggonService implements WaggonServiceInterface {
    @Autowired
    WaggonRepositoryInterface waggonRepository;
    @Transactional
    @Override
    public List<Waggon> getAllWaggons() {
        return waggonRepository.getAllWaggons();
    }
    @Transactional
    @Override
    public void addWaggon(Waggon waggon) {
        waggonRepository.addWaggon(waggon);
    }
    @Transactional
    @Override
    public void removeWaggon(int id) {
        waggonRepository.removeWaggon(id);
    }
    @Transactional
    @Override
    public void updateWaggon(Waggon waggon) {
        waggonRepository.updateWaggon(waggon);
    }
    @Transactional
    @Override
    public Waggon getWaggon(int id) {
        return waggonRepository.getWaggon(id);
    }
}
