package com.kiosk.ingest.customerorder.controller;


import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Log
@RestController
public class IngestCustomerOrderController {

    @Value("${kiosk.author.email}")
    private String email;

    @Value("${kiosk.author}")
    private String author;

    @Value("${kiosk.mobile : 1234567890}")
    private String mobile;

    @Value("${spring.kafka.producer.bootstrap-servers : localhost:9092}")
    private String kafkaServer;

    @GetMapping("/test")
    public String test(){

        String text = kafkaServer + " --- " + author + " --- " + email + " --- " + new Date();
        log.info(text);
        return text;
    }
}
