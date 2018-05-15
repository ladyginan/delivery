package com.app.service.impl;

import com.app.model.Waggon;
import com.app.repository.WaggonRepositoryInterface;
import com.app.service.WaggonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WaggonService implements WaggonServiceInterface {
    @Autowired
    WaggonRepositoryInterface waggonRepository;

    @Override
    public List<Waggon> getAllWaggons() {
        return waggonRepository.getAllWaggons();
    }

    @Override
    public void addWaggon(Waggon waggon) {
        waggonRepository.addWaggon(waggon);
    }

    @Override
    public void removeWaggon(String id) {
        waggonRepository.removeWaggon(id);
    }

    @Override
    public void updateWaggon(Waggon waggon) {
        waggonRepository.updateWaggon(waggon);
    }

    @Override
    public Waggon getWaggon(String id) {
        return null;
    }
}
