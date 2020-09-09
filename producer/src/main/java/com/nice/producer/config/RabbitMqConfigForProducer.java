package com.nice.producer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Required to declare a queue and a message converter on application startup.
@Configuration
public class RabbitMqConfigForProducer {

    @Value("${app.queue}")
    String queue;

    @Bean
    Queue queue() {
        System.out.println("queue = " + queue);
        return new Queue(queue);
    }

    @Bean
    Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}