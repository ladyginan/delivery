package com.app.service.impl;

import com.app.configuration.rabbitMq.DriverJson;
import com.app.configuration.rabbitMq.OrderJson;
import com.app.configuration.rabbitMq.Producer;
import com.app.configuration.rabbitMq.WaggonJson;
import com.app.service.DriverJsonServiceInterface;
import com.app.service.OrderJsonServiceInterface;
import com.app.service.SendJsonOrdersInterface;
import com.app.service.WaggonJsonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendJsonOrders implements SendJsonOrdersInterface {

    @Autowired
    OrderJsonServiceInterface orderJsonService;
    @Autowired
    WaggonJsonServiceInterface waggonJsonService;
    @Autowired
    DriverJsonServiceInterface driverJsonService;
    @Autowired
    Producer producer;
    @Override
    public void sendJson() {
        List<OrderJson> listJson = orderJsonService.getAllOrdersJson();
        DriverJson driverJson = driverJsonService.getDriverJson();
        WaggonJson waggonJson = waggonJsonService.getWaggonJson();
        for(OrderJson orderString : listJson){
            producer.sendMessage(orderString);
        }
        producer.sendMessageDrivers(driverJson);
        producer.sendMessageWaggons(waggonJson);
    }

}
