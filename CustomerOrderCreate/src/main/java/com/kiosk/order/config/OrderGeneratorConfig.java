package com.kiosk.order.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@RefreshScope
public class OrderGeneratorConfig {

    @Value("${kiosk.customer.order.topic}")
    private String topic;

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String kafkaServer;

    @Value("${config.location}")
    private String configLocation;
}
