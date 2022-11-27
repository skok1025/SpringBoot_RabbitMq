package com.cafe24.rabbitmq.config;

import com.cafe24.rabbitmq.constant.RabbitMqConst;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {



    @Bean
    Queue queue() {
        return new Queue(RabbitMqConst.SPRING_BOOT_QUEUE, false);
    }

    @Bean
    Queue queue1() {
        return new Queue(RabbitMqConst.QUEUE_1, false);
    }

    @Bean
    Queue queue2() {
        return new Queue(RabbitMqConst.QUEUE_2, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(RabbitMqConst.TOPIC_EXCHANGE);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                  MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}