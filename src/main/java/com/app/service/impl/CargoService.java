package com.app.service.impl;

import com.app.model.Cargo;
import com.app.repository.CargoRepositoryInterface;
import com.app.service.CargoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class CargoService implements CargoServiceInterface {
    @Autowired
    private CargoRepositoryInterface cargoRepository;



    @Override
    public List<Cargo> getAllCargoes() {
        return cargoRepository.getAllCargoes();
    }

    @Override
    public Cargo getCargo(int id) {
        return cargoRepository.getCargo(id);
    }

    @Override
    public void addCargo(Cargo cargo) {
       cargoRepository.addCargo(cargo);
    }
}
