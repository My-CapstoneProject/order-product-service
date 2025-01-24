package com.sr.order_product_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sr.order_product_service.entity.OrderProductEntity;
import com.sr.order_product_service.service.OrderProductService;

import java.util.List;

@RestController
@RequestMapping("/api/orderproduct")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

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
}

