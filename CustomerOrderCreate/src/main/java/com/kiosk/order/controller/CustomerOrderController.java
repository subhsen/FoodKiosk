package com.kiosk.order.controller;

import com.kiosk.order.config.OrderGeneratorConfig;
import com.kiosk.order.producer.CustomerOrderProducer;
import com.kiosk.shared.model.CustomerOrderItems;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Log
@RestController
public class CustomerOrderController {

    @Autowired
    private OrderGeneratorConfig orderGeneratorConfig;

    @Autowired
    private CustomerOrderProducer customerOrderProducer;

    @PostMapping("/customer/order/new")
    public ResponseEntity<String> saveCustomerOrder(@RequestBody CustomerOrderItems customerOrderItems) {

        customerOrderProducer.publishCustomerOrder(customerOrderItems);

        return ResponseEntity.status(HttpStatus.CREATED).contentType(customerOrderItems);
    }

    @GetMapping("/list/config")
    public ResponseEntity<String> listConfigurations() {

        String config = orderGeneratorConfig.getConfigLocation() + " --- " +
                orderGeneratorConfig.getKafkaServer() + " --- " +
                orderGeneratorConfig.getTopic() + " --- " +
                new Date();

        log.info(config);

        return ResponseEntity.status(HttpStatus.CREATED).body(config);
    }
}
