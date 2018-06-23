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
    @Autowired
    private OrderJsonServiceInterface ordersJson;

    public Producer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendMessage(OrderJson message) {
        rabbitTemplate.convertAndSend("ordersQueue", message.toJson());
    }
}
