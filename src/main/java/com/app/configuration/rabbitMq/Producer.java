package com.app.configuration.rabbitMq;


import com.app.service.OrderJsonServiceInterface;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Producer {
    @Autowired
    private final RabbitTemplate rabbitTemplate;


    public Producer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendMessage(OrderJson messageOrder) {
        rabbitTemplate.convertAndSend("ordersQueue", messageOrder.toJson());
    }
    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendMessageDrivers(DriverJson messageDriver){
        rabbitTemplate.convertAndSend("drivers", messageDriver.toJson());
    }
    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendMessageWaggons(WaggonJson messageWaggon){
        rabbitTemplate.convertAndSend("waggons", messageWaggon.toJson());
    }
}

