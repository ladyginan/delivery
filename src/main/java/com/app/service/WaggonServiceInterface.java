package com.app.service;

import com.app.DTO.WaggonDTO;
import com.app.model.Waggon;

import java.util.List;

public interface WaggonServiceInterface {

    List<Waggon> getAllWaggons();

    void addWaggon(Waggon waggon);

    void removeWaggon(int id);

    WaggonDTO updateWaggon(WaggonDTO waggonDTO);

    Waggon getWaggon(int id);

    WaggonDTO getWaggonDTO(int id);

}
