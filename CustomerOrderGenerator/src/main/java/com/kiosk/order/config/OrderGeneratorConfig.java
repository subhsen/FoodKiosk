package com.kiosk.order.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Configuration
@RefreshScope
public class OrderGeneratorConfig {

   @Value("${kiosk.author.email}")
    private String email;

    @Value("${kiosk.author}")
    private String author;

    @Value("${topic.kiosk.customer.order}")
    private String topic;

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String kafkaServer;
}
