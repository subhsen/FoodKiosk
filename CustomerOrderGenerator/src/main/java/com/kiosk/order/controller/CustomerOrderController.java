package com.kiosk.order.controller;

import com.kiosk.order.config.OrderGeneratorConfig;
import com.kiosk.order.producer.CustomerOrderProducer;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<String> saveCustomerOrder(String customerOrder){

        customerOrder = orderGeneratorConfig.getKafkaServer() + " --- " +
                orderGeneratorConfig.getAuthor() + " --- " +
                orderGeneratorConfig.getEmail() + " --- " +
                new Date();
        log.info(customerOrder);

        //customerOrderProducer.publishCustomerOrder(customerOrder);

        return new ResponseEntity<String>(customerOrder, HttpStatus.CREATED);
    }
}
