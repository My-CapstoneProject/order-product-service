package com.sr.order_product_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OrderProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProductServiceApplication.class, args);
	}

}
