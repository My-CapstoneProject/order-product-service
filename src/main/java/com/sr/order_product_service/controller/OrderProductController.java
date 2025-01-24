package com.sr.order_product_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sr.order_product_service.entity.OrderProductEntity;
import com.sr.order_product_service.pojo.OrderPojo;
import com.sr.order_product_service.pojo.OrderProductPojo;
import com.sr.order_product_service.pojo.ProductPojo;
import com.sr.order_product_service.service.OrderClient;
import com.sr.order_product_service.service.OrderProductService;
import com.sr.order_product_service.service.ProductClient;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orderproduct")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;
    
    @Autowired
	OrderClient orderClient;

    @Autowired
	ProductClient productClient;
    // Create a new OrderProduct relationship
    @PostMapping
    public ResponseEntity<OrderProductEntity> addOrderProduct(@RequestBody OrderProductEntity orderProduct) {
        OrderProductEntity createdOrderProduct = orderProductService.addOrderProduct(orderProduct);
        return ResponseEntity.ok(createdOrderProduct);
    }

    // Get all OrderProduct relationships
    @GetMapping
    public ResponseEntity<List<OrderProductEntity>> getAllOrderProducts() {
        List<OrderProductEntity> allOrderProducts = orderProductService.getAllOrderProducts();
        return ResponseEntity.ok(allOrderProducts);
    }

    // Get all products by order ID
    @GetMapping("/order/{orderId}/products")
    public ResponseEntity<List<OrderProductEntity>> getProductsByOrderId(@PathVariable int orderId) {
        List<OrderProductEntity> products = orderProductService.getProductsByOrderId(orderId);
        return ResponseEntity.ok(products);
    }

    // Get all orders by product ID
    @GetMapping("/product/{productId}/orders")
    public ResponseEntity<List<OrderProductEntity>> getOrdersByProductId(@PathVariable int productId) {
        List<OrderProductEntity> orders = orderProductService.getOrdersByProductId(productId);
        return ResponseEntity.ok(orders);
    }
    
    @GetMapping("/{opid}")
	public ResponseEntity<OrderProductPojo> getAOrderProduct(@PathVariable int opid) {
	    Optional<OrderProductEntity> inOptional = orderProductService.getAOrderProduct(opid);
	    
	    if (inOptional.isPresent()) {
	        OrderProductEntity orderProduct = inOptional.get();  // Unwrap the Optional
	        
	        OrderProductPojo inPojo = new OrderProductPojo();
	        
	        // Now use Feign client to fetch department by departmentId
	        OrderPojo order = orderClient.getOrderById(orderProduct.getOrderId());
	        ProductPojo product = productClient.getProductById(orderProduct.getProductId());
	        
//	        StorePojo store = storeClient.getStoreById(inventory.getInStoreId());
	        
	        
	        // Set the department to the employee
	        inPojo.setOrderProductId(orderProduct.getOrderProductId());
	        inPojo.setOrderId(orderProduct.getOrderId());
	        inPojo.setProductId(orderProduct.getProductId());
	        inPojo.setSalesQuantity(orderProduct.getSalesQuantity());
	        inPojo.setOrderPojo(order);
	        inPojo.setProductPojo(product);
	        
	        
	        return new ResponseEntity<>(inPojo, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Employee not found
	    }
	}

}

