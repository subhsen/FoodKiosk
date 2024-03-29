package in.kiosk.controller;

import in.kiosk.config.Config;
import in.kiosk.shared.model.CustomerOrder;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Log
@RestController
public class CustomerOrderController {

//    @Autowired
//    private CustomerOrderProducer customerOrderProducer;

    @Autowired
    private KafkaTemplate<String, CustomerOrder> kafkaTemplate;

    @PostMapping(value = "/customer/order/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerOrder> saveCustomerOrder(@RequestBody CustomerOrder customerOrder) {

        log.info("Publishing ::: " + customerOrder.toString());

       // customerOrderProducer.publishCustomerOrder(customerOrderItems);

        kafkaTemplate.send(Config.topic, customerOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerOrder);
    }


    @GetMapping("/list/config")
    @RateLimiter(name = "listConfigurationsRateLimiter" , fallbackMethod = "listConfigurationsFallback")
    public ResponseEntity<String> listConfigurations() {

        log.info(Config.topic + " --- " + new Date());
        return ResponseEntity.ok(Config.topic);
    }

    // falback method
    public ResponseEntity<String> listConfigurationsFallback(Throwable throwable) {

        log.info("Rate limit applied on /list/config No further calls are accepted");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Retry-After", "1"); //retry after one second

        return ResponseEntity
                .status(HttpStatus.TOO_MANY_REQUESTS)
                .headers(responseHeaders) //send retry header
                .body("Too many request - No further calls are accepted...");
    }
}
