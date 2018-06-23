package com.app.service.impl;

import com.app.model.Cargo;
import com.app.repository.CargoRepositoryInterface;
import com.app.service.CargoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class CargoService implements CargoServiceInterface {
    @Autowired
    private CargoRepositoryInterface cargoRepository;

    @Transactional
    @Override
    public List<Cargo> getAllCargoes() {
        return cargoRepository.getAllCargoes();
    }

    @Transactional
    @Override
    public Cargo getCargo(int id) {
        return cargoRepository.getCargo(id);
    }

    @Transactional
    @Override
    public void addCargo(Cargo cargo) {
        cargoRepository.addCargo(cargo);
    }
}
