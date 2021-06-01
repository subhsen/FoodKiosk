package com.kiosk.ingest.customerorder.controller;


import com.kiosk.ingest.customerorder.config.Config;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log
@RestController
public class IngestCustomerOrderController {

    @Autowired
    private Config config;

    @GetMapping("/test")
    public List<Integer> test(){

        log.info(config.getMyList().toString());
        return config.getMyList();
    }
}
