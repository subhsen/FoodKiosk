package com.kiosk.order;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@Log
@SpringBootApplication
public class CustomerOrderGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerOrderGeneratorApplication.class, args);
	}

	@PostConstruct
	public void runtimeInfo(){

		log.info("totalMemory = " + Runtime.getRuntime().totalMemory()/1000000);
		log.info("maxMemory   = " + Runtime.getRuntime().maxMemory()/1000000);
		log.info("freeMemory  = " + Runtime.getRuntime().freeMemory()/1000000);
	}
}
