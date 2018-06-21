package com.app.controllers;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/send")
public class Send {

//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//
//        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
//        String message = "Hello World!";
//        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
//        System.out.println(" [x] Sent '" + message + "'");
//
//        channel.close();
//        connection.close();
//    }
//
//        public static void main(String[] args) throws InterruptedException {
//            AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com.app.configuration.rabbitMq.RabbitMQConfig");
//            AmqpTemplate template = ctx.getBean(RabbitTemplate.class);
//            template.convertAndSend("Hello, world!");
//            Thread.sleep(1000);
//        }
}