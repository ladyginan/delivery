package com.app.service.impl;

import com.app.DTO.OrderDTO;
import com.app.model.Driver;
import com.app.model.Order;
import com.app.model.Waggon;
import com.app.model.WayPoint;
import com.app.repository.DriversRepositoryInterface;
import com.app.repository.OrderRepositoryInterface;
import com.app.repository.WaggonRepositoryInterface;
import com.app.repository.WayPointRepositoryInterface;
import com.app.repository.impl.WayPointRepository;
import com.app.service.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderServiceInterface {
    @Autowired
    private OrderRepositoryInterface orderRepository;
    @Autowired
    private DriversRepositoryInterface driverRepository;
    @Autowired
    private WaggonRepositoryInterface waggonRepository;
    @Autowired
    private WayPointRepositoryInterface wayPointRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public void addOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setRegNumberOrder(orderDTO.getRegNumberOrderDTO());
        order.setStatus(orderDTO.getStatusDTO());
        Waggon waggon = waggonRepository.getWaggonByRegNumber(orderDTO.getRegNumberWaggonDTO());
        order.setCurrentWaggon(waggon);
        for(int i : orderDTO.getWayPointListDTO()){
            WayPoint point = wayPointRepository.findWayPointById(i);
            order.getPointList().add(point);
        }
        for(int i : orderDTO.getDriversDTO()){
            Driver driver =  driverRepository.getDriver(i);
            order.getDrivers().add(driver);
        }
        orderRepository.addOrder(order);
    }
}
