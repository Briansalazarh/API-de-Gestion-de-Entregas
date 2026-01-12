package com.brian.delivery.delivery_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DeliveryApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DeliveryApiApplication.class, args);
	}
}
