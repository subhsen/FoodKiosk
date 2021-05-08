package com.kiosk.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class KioskConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KioskConfigServerApplication.class, args);
	}

}
