//package in.kiosk.producer;
//
//import in.kiosk.shared.model.CustomerOrderItems;
//import lombok.extern.java.Log;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.stereotype.Service;
//import org.springframework.util.concurrent.ListenableFuture;
//
//
//@Log
//@Service
//public class CustomerOrderProducer {
//
//    @Value(value = "${kiosk.customer.order.topic}")
//    private String TOPIC;
//
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    public void publishCustomerOrder(CustomerOrderItems customerOrderItems) {
//
//        ListenableFuture<SendResult<String, CustomerOrderItems>> send = kafkaTemplate.send(TOPIC, customerOrderItems);
//        log.info("Published -> " + customerOrderItems.toString());
//    }
//}
