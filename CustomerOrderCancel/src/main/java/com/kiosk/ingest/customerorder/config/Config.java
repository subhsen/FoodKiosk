package com.kiosk.ingest.customerorder.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@Configuration
public class Config {

    @Value("${my.list}")
    List<Integer> myList;

    @Value("${my.map}")
    private Map<String, Map<String, Integer>> myMap;

//    @Value("${kiosk.author.email}")
//    private String email;
//
//    @Value("${kiosk.author}")
//    private String author;
//
//    @Value("${kiosk.mobile : 1234567890}")
//    private String mobile;
//
//    @Value("${spring.kafka.producer.bootstrap-servers : localhost:9092}")
//    private String kafkaServer;
}
