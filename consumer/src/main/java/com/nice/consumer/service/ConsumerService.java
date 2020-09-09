package com.nice.consumer.service;

import com.nice.consumer.dto.MessageDto;

public class ConsumerService {

//    @RabbitListener(queues = "${app.queue}")
    public void getMessages(final MessageDto dto) {
        System.out.println("Received following message from rabbitmq= " + dto);

    }

    public void applyMessageLogic() {

    }
}
