package com.cafe24.rabbitmq.controller;

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
	private static final String topicExchange = "spring-boot-exchange";
	
	public ProduceController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
	
	@ResponseBody
	@GetMapping("/send")
	public String send() {
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend("queue1", "hello world");
		rabbitTemplate.convertAndSend("queue2", "hello world2");

//		String send_message = "[{\"title\":\"제목1\",\"content\":\"내용a1\"}]";
//        rabbitTemplate.convertAndSend(topicExchange, "foo.bar.baz", send_message);
		return "send!!";
	}
	
}
