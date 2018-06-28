package com.app.service.impl;

import com.app.configuration.rabbitMq.Producer;
import com.app.model.Order;
import com.app.service.UpdateOrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UpdateOrder implements UpdateOrderInterface {

    @Autowired
    Producer producer;
    @Autowired
    OrderJsonService orderJsonService;
    @Autowired
    DriverJsonService driverJsonService;
    @Autowired
    WaggonJsonService waggonJsonService;
@Transactional
    @Override
    public void sendNewOrder(Order order) {
        producer.sendMessage(orderJsonService.getNewOrderJson(order));
        producer.sendMessageDrivers(driverJsonService.getDriverJson());
        producer.sendMessageWaggons(waggonJsonService.getWaggonJson());
    }
}
