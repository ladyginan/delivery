package com.app.repository;

import com.app.model.Cargo;

import java.util.List;

public interface CargoRepositoryInterface {
    List<Cargo> getAllCargos();

    Cargo getCargo(int id);
}
