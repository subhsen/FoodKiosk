package com.kiosk.ingest.customerorder.consumer;

import lombok.extern.java.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Log
@Service
public class CustomerOrderConsumer {

    @KafkaListener(topics = "topic.kiosk.customer.order", groupId = "group_id")
    public void consume(String message) throws IOException {

        log.info(String.format("### Consumed message: %s", message));
    }
}
