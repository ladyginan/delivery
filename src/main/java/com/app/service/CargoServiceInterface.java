package com.app.service;

import com.app.model.Cargo;

import java.util.List;

public interface CargoServiceInterface {
    List<Cargo> getAllCargoes();

    Cargo getCargo(int id);

    void addCargo(Cargo cargo);
}
