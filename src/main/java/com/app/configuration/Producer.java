package com.app.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public Producer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendMessage() {
        final CustomMessage message = new CustomMessage("Hello there!");
        rabbitTemplate.convertAndSend(message);
    }
}

