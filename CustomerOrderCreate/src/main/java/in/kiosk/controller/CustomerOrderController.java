package in.kiosk.controller;

import in.kiosk.order.config.OrderGeneratorConfig;
import in.kiosk.producer.CustomerOrderProducer;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Log
@RestController
public class CustomerOrderController {

    @Autowired
    private OrderGeneratorConfig orderGeneratorConfig;

    @Autowired
    private CustomerOrderProducer customerOrderProducer;

//    @PostMapping(value = "/customer/order/new", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<CustomerOrderItems> saveCustomerOrder(@RequestBody CustomerOrderItems customerOrderItems) {
//
//        customerOrderProducer.publishCustomerOrder(customerOrderItems);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(customerOrderItems);
//    }

    @GetMapping("/list/config")
    public ResponseEntity<String> listConfigurations() {

        String config = orderGeneratorConfig.getConfigLocation() + " --- " +
                orderGeneratorConfig.getKafkaServer() + " --- " +
                orderGeneratorConfig.getTopic() + " --- " +
                new Date();

        log.info(config);

        return ResponseEntity.status(HttpStatus.CREATED).body(config);
    }
}
