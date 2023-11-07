package com.demo.serverreload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServerReloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerReloadApplication.class, args);
	}

}
