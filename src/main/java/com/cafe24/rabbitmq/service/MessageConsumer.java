package com.cafe24.rabbitmq.service;

import com.cafe24.rabbitmq.constant.RabbitMqConst;
import com.cafe24.rabbitmq.dto.TestDTO;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MessageConsumer {

    @RabbitListener(queues = RabbitMqConst.QUEUE_1)
    public void receiveQueue1Message(final Message message) {
        String rawMessage = new String(message.getBody());

        System.out.println("=============Consumer START===========");
        System.out.println(rawMessage);
        System.out.println("=============Consumer END===========");
    }

    @RabbitListener(queues = RabbitMqConst.QUEUE_2)
    public void receiveQueue2Message(TestDTO dto) {
        System.out.println("=============Consumer2 START===========");
        System.out.println("- id: " + dto.getId());
        System.out.println("- age: " + dto.getAge());
        System.out.println("=============Consumer2 END===========");
    }

}