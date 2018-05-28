package com.app.service.impl;

import com.app.DTO.WaggonDTO;
import com.app.model.Map;
import com.app.model.Waggon;
import com.app.repository.MapRepositoryInterface;
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
    @Autowired
    MapRepositoryInterface mapRepository;
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
    public WaggonDTO updateWaggon(WaggonDTO waggonDTO) {
        Map city = mapRepository.findCityById(waggonDTO.getMapId());

        Waggon waggon = waggonRepository.getWaggon(waggonDTO.getIdWaggon());
        waggon.setRegNumber(waggonDTO.getRegNumber());
        waggon.setStatus(waggonDTO.getStatus());
        waggon.setShiftSize(waggonDTO.getShiftSize());
        waggon.setCapacity(waggonDTO.getCapacity());
        waggon.setCity(city);
        waggonRepository.updateWaggon(waggon);

        waggon = waggonRepository.updateWaggon(waggon);
        return new WaggonDTO(waggon);

    }
    @Transactional
    @Override
    public Waggon getWaggon(int id) {
        return waggonRepository.getWaggon(id);
    }
    @Transactional
    @Override
    public WaggonDTO getWaggonDTO(int id) {
        Waggon waggon = waggonRepository.getWaggon(id);
        WaggonDTO waggonDTO = new WaggonDTO(waggon);
        return waggonDTO;
    }
}
