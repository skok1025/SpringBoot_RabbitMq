package com.cafe24.rabbitmq.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "spring-boot")
    public void receiveMessage(final Message message) {
    	String rawMessage = new String(message.getBody());
    	
    	System.out.println("=============Consumer START===========");
        System.out.println(rawMessage);
        System.out.println("=============Consumer END===========");
    }

}