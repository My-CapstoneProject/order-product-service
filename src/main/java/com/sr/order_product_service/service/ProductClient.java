package com.sr.order_product_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sr.order_product_service.pojo.OrderPojo;
import com.sr.order_product_service.pojo.ProductPojo;

@FeignClient(name = "product-service", url = "http://localhost:8001/api/products")
public interface ProductClient {
	@GetMapping("/{productId}")
	ProductPojo getProductById(@PathVariable int productId);
}
