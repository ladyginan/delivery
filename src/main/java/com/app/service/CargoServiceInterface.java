package com.app.service;

import com.app.model.Cargo;

import java.util.List;

public interface CargoServiceInterface {
    List<Cargo> getAllCargos();

    Cargo getCargo(int id);
}
