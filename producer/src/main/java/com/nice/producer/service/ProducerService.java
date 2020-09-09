package com.nice.producer.service;

import com.nice.producer.dto.MessageDto;
import com.nice.producer.dto.MessageType;
import com.nice.producer.validator.MessageValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static Logger logger = LogManager.getLogger(ProducerService.class);

    @Autowired
    private MessageValidatorImpl messageValidatorImpl;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${app.queue}")
    private String queue;

    public String handleMessage(String message) {
        MessageType messageType = this.messageValidatorImpl.validate(message);
        if(!messageType.equals(MessageType.INVALID)) {
            this.publishEventToRabbitMq(message, messageType);
        }
        return message;
    }

    @Async
    private void publishEventToRabbitMq(final String message, final MessageType type) {
        final MessageDto dto = new MessageDto(message, type);
        logger.info("Sending the following event object to the queue: " + message);
        rabbitTemplate.convertAndSend(queue, dto);
        logger.info("Message successfully sent to the rabbitMq.");
    }
}
