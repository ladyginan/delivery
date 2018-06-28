package com.app.service.impl;

import com.app.model.Cargo;
import com.app.repository.CargoRepositoryInterface;
import com.app.service.CargoServiceInterface;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class CargoService implements CargoServiceInterface {
    @Autowired
    private CargoRepositoryInterface cargoRepository;

    @Transactional
    @Override
    public List<Cargo> getAllCargoes() {
        log.info("List of all cargoes in service.");
        return cargoRepository.getAllCargoes();
    }

    @Transactional
    @Override
    public Cargo getCargo(int id) {
        log.info("Cargo is found by id.");
        return cargoRepository.getCargo(id);
    }

    @Transactional
    @Override
    public void addCargo(Cargo cargo) {
        log.info("New cargo in service.");
        cargoRepository.addCargo(cargo);
    }
}
