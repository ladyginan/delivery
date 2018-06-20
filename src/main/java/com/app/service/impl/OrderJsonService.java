package com.app.service.impl;

import com.app.configuration.rabbitMq.OrderJson;
import com.app.model.Cargo;
import com.app.model.Driver;
import com.app.model.Order;
import com.app.model.WayPoint;
import com.app.repository.*;
import com.app.service.OrderJsonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderJsonService implements OrderJsonServiceInterface {

    @Autowired
    OrderRepositoryInterface orderRepository;
    @Autowired
    DriverOrderRepositoryInterface driverOrderRepository;
    @Autowired
    WayPointOrderRepositoryInterface wayPointOrderRepository;
    @Autowired
    DriversRepositoryInterface driversRepository;
    @Autowired
    WayPointRepositoryInterface wayPointRepository;
    @Autowired
    CargoRepositoryInterface cargoRepository;

    @Transactional
    @Override
    public List<OrderJson> getAllOrdersJson() {
        List<Order> listOrders = orderRepository.getAllOrders();
        List<OrderJson> ordersJson = new ArrayList<>();


        for(Order order : listOrders){
                OrderJson orderJson = new OrderJson();
                orderJson.setRegNumberOrder(order.getRegNumberOrder());
                orderJson.setOrderStatus(order.getStatus());
                orderJson.setRegNumber(order.getCurrentWaggon().getRegNumber());

                List<String> drivers = getAllDriversOrder(driverOrderRepository.getAllDriversOfOrder(order));
                orderJson.setDrivers(drivers);
                List<String> wayPoints = getAllWayPointsOrder(wayPointOrderRepository.getAllWayPointsOfOrder(order));
                orderJson.setWayPoints(wayPoints);
            ordersJson.add(orderJson);
        }
        return ordersJson;
    }

    @Transactional
    @Override
    public List<String> getAllDriversOrder(List<Driver> drivers) {
        List<String> listOfDrivers = new ArrayList<>();
        for(Driver driver : drivers){
            Driver driverForRead = driversRepository.getDriver(driver.getIdDriver());

            String fullDriverName = driverForRead.getName() + " " +
                    driverForRead.getSecondName() + " " +
                    driverForRead.getPersonalNumber();

            listOfDrivers.add(fullDriverName);
        }
        return listOfDrivers;
    }

    @Transactional
    @Override
    public List<String> getAllWayPointsOrder(List<WayPoint> wayPoints) {
        List<String> listOfCities = new ArrayList<>();
        for(WayPoint point : wayPoints){
            WayPoint wayPointForRead = wayPointRepository.findWayPointById(point.getIdWayPoint());
            Cargo cargo = cargoRepository.getCargo(wayPointForRead.getCargo().getIdCargo());

            String nameOfPoint = wayPointForRead.getCity().getCity() + " " +
                    wayPointForRead.getOrderType() + "-" +
                    cargo.getName() + " " +
                    cargo.getCargoNumber();
            listOfCities.add(nameOfPoint);
        }
        return listOfCities;
    }
}
