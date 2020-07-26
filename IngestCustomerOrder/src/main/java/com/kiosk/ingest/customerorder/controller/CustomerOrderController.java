package com.kiosk.ingest.customerorder.controller;


import lombok.extern.java.Log;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequestMapping("/kiosk/")
public class CustomerOrderController {

    @PostMapping("/newOrder")
    public ResponseEntity<String> placeNewOrder(@RequestBody String requestBody){

        log.info("Inside CustomerOrderController.placeNewOrder...");

        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
