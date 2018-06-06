package com.app.repository.impl;

import com.app.model.Driver;
import com.app.model.Order;
import com.app.model.Waggon;
import com.app.model.WayPoint;
import com.app.repository.DriverLoginRepositoryInterface;
import com.app.repository.DriversRepositoryInterface;
import com.app.repository.WaggonRepositoryInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DriverLoginRepository implements DriverLoginRepositoryInterface {
    @Autowired
    private final SessionFactory factory;
    @Autowired
    private DriversRepositoryInterface driversRepository;
    @Autowired
    private WaggonRepositoryInterface waggonRepository;

    public DriverLoginRepository(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public int findDriverPersonalNumber(int idDriver) {
        Driver driver = driversRepository.getDriver(idDriver);
        return driver.getPersonalNumber();
    }

    @Override
    public List<Driver> findAllCompanions(int idOrder) {
        List<Driver> companions = factory.getCurrentSession().createQuery("from Driver where idOrder = :idOrder").list();
        return companions;
    }

    @Override
    public String findCurrentWaggon(int idDriver) {
        Driver driver = driversRepository.getDriver(idDriver);
        Waggon waggon = waggonRepository.getWaggon(driver.getWaggon().getIdWaggon());
        return waggon.getRegNumber();
    }

    @Override
    public int findOrderNumber(int idDriver) {
        return 0;
    }

    @Override
    public List<WayPoint> findAllOrderPoints(int idDriver) {
        List<WayPoint>points = factory.getCurrentSession().createQuery("from Map where idOrder = :idOrder").list();
        return points;
    }

    @Override
    public int settingDriverTime(int idDriver) {
        return 0;
    }

    @Override
    public void changeDriverStatus(int idDriver) {

    }

    @Override
    public void changeCargoStatus(int idDriver) {

    }
}
