package in.kiosk.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@RefreshScope
public class Config {

    @Value("${kiosk.customer.order.topic}")
    public static String topic;

    @Value("${spring.kafka.producer.bootstrap-servers}")
    public static String kafkaBootstrapServer;

    @Value("${config.location}")
    private String configLocation;
}
