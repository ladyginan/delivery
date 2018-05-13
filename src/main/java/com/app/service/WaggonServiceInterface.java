package com.app.service;

import com.app.model.Waggon;

import java.util.List;

public interface WaggonServiceInterface {

    List<Waggon> getAllWaggons();

    void addWaggon(Waggon waggon);

    void removeWaggon(int id);

    void updateWaggon(Waggon waggon);

    Waggon getWaggon(int id);
}
