package com.kiosk.order.producer;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log
@Service
public class CustomerOrderProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private static final String TOPIC = "topic.kiosk.customer.order";

    public void publishCustomerOrder(String message){

        kafkaTemplate.send(TOPIC, message);
        log.info("Published -> " + message);
    }
}
