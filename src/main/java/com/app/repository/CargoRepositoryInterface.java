package com.app.repository;

import com.app.model.Cargo;

import java.util.List;

public interface CargoRepositoryInterface {
    List<Cargo> getAllCargoes();

    Cargo getCargo(int id);

    void addCargo(Cargo cargo);

    Cargo updateCargo(Cargo cargo);
}
