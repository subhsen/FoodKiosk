package com.kiosk.order.controller;

import com.kiosk.order.producer.CustomerOrderProducer;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Log
@RestController
public class CustomerOrderController {

    @Value("${kiosk.author.email}")
    private String email;

    @Value("${kiosk.author}")
    private String author;

    @Value("${kiosk.mobile : 1234567890}")
    private String mobile;

    @Value("${spring.kafka.producer.bootstrap-servers : localhost:9092}")
    private String kafkaServer;

    @Autowired
    private CustomerOrderProducer customerOrderProducer;

    @PostMapping("/customer/order/new")
    public ResponseEntity saveCustomerOrder(String customerOrder){

        customerOrder = kafkaServer + " --- " + author + " --- " + email + " --- " + new Date();
        log.info(customerOrder);

        //customerOrderProducer.publishCustomerOrder(customerOrder);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
