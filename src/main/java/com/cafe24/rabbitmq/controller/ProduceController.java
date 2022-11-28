package com.cafe24.rabbitmq.controller;

import com.cafe24.rabbitmq.constant.RabbitMqConst;
import com.cafe24.rabbitmq.dto.TestDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Producer 역할
 * @author skok
 *
 */
@Controller
public class ProduceController {

	private final RabbitTemplate rabbitTemplate;
	
	public ProduceController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
	
	@ResponseBody
	@GetMapping("/send")
	public String send() {
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(RabbitMqConst.QUEUE_1, "hello world");
		rabbitTemplate.convertAndSend(RabbitMqConst.QUEUE_2, new TestDTO("test", 11));

		return "send!!";
	}
	
}
