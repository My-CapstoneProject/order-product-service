package com.sr.order_product_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sr.order_product_service.pojo.OrderPojo;

@FeignClient(name = "order-service", url = "http://localhost:8002/api/orders")
public interface OrderClient {
	   @GetMapping("/{orderId}")
	   OrderPojo getOrderById(@PathVariable int orderId);

}
