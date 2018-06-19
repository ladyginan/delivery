package com.app.configuration.rabbitMq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    private final RabbitTemplate rabbitTemplate;


    public Producer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 5000, initialDelay = 500)

    public void sendMessage() {

        final OrderJson message = new OrderJson("Hello");
        rabbitTemplate.convertAndSend("ordersQueue", message.toString());
    }
}

