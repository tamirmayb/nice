package com.nice.consumer.service;

import com.nice.consumer.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private static final Logger log = LoggerFactory.getLogger(ConsumerService.class);
    private double sum = 0;

    @RabbitListener(queues = "${app.queue}")
    public void getMessages(final MessageDto dto) {
        log.info("Received following message from rabbitmq= " + dto.getMessage());
        this.applyMessageLogic(dto);
    }

    private void applyMessageLogic(MessageDto dto) {
        String messageContent = dto.getMessage().replaceAll("'", "");
        switch (dto.getType()) {
            case FRACTION:
                String[] split = messageContent.split("/");
                double numerator = Double.parseDouble(split[0]);
                double denominator = Double.parseDouble(split[1]);
                double num = numerator / denominator;
                this.sum += num;
                break;
            case DECIMAL:
            case INTEGER:
                sum += Double.parseDouble(messageContent);
        }

        log.info("sum = " + sum);
    }
}
