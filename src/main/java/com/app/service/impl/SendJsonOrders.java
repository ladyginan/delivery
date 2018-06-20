package com.app.service.impl;

import com.app.configuration.rabbitMq.OrderJson;
import com.app.configuration.rabbitMq.Producer;
import com.app.service.OrderJsonServiceInterface;
import com.app.service.SendJsonOrdersInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendJsonOrders implements SendJsonOrdersInterface {

    @Autowired
    OrderJsonServiceInterface orderJsonService;
    @Autowired
    Producer producer;
    @Override
    public void sendJson() {
        List<OrderJson> listJson = orderJsonService.getAllOrdersJson();
        for(OrderJson orderString : listJson){
            producer.sendMessage(orderString);
        }
    }
}
