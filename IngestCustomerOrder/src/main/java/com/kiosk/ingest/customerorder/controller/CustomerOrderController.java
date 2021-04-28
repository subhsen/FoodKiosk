package com.kiosk.ingest.customerorder.controller;


import lombok.extern.java.Log;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Log
@RestController
@RequestMapping("/kiosk/")
public class CustomerOrderController {

    @PostMapping("/newOrder")
    public ResponseEntity<String> placeNewOrder(@RequestBody String requestBody){

        log.info("Inside CustomerOrderController.placeNewOrder...");

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test(){
        return "Hello World !!! " + LocalTime.now().toString();
    }
}
