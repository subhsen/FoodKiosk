package in.kiosk.controller;

import in.kiosk.config.OrderGeneratorConfig;
import in.kiosk.producer.CustomerOrderProducer;
import in.kiosk.shared.model.CustomerOrderItems;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Log
@RestController
public class CustomerOrderController {

    @Autowired
    private OrderGeneratorConfig orderGeneratorConfig;

    @Autowired
    private CustomerOrderProducer customerOrderProducer;


    @PostMapping(value = "/customer/order/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerOrderItems> saveCustomerOrder(@RequestBody CustomerOrderItems customerOrderItems) {

        log.info("Publishing ::: " + customerOrderItems.toString());

        customerOrderProducer.publishCustomerOrder(customerOrderItems);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerOrderItems);
    }


    @GetMapping("/list/config")
    @RateLimiter(name = "listConfigurationsRateLimiter", fallbackMethod = "listConfigurationsFallback")
    public ResponseEntity<String> listConfigurations() {

        log.info(orderGeneratorConfig.toString() + " --- " + new Date());
        return ResponseEntity.ok().body(orderGeneratorConfig.toString());
    }

    // falback method
    public ResponseEntity<String> listConfigurationsFallback() {

        log.info("Rate limit applied on /list/config No further calls are accepted");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Retry-After", "1"); //retry after one second

        return ResponseEntity
                .status(HttpStatus.TOO_MANY_REQUESTS)
                .headers(responseHeaders) //send retry header
                .body("Too many request - No further calls are accepted...");
    }
}
