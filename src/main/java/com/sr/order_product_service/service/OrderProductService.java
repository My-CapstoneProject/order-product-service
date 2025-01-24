package com.sr.order_product_service.service;

import com.sr.order_product_service.dao.OrderProductRepo;
import com.sr.order_product_service.entity.OrderProductEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepo orderProductRepository;

    public OrderProductEntity addOrderProduct(OrderProductEntity orderProduct) {
        return orderProductRepository.saveAndFlush(orderProduct);
    }

    public List<OrderProductEntity> getAllOrderProducts() {
        return orderProductRepository.findAll();
    }

    public List<OrderProductEntity> getProductsByOrderId(int orderId) {
        return orderProductRepository.findAll().stream().filter(op -> op.getOrderId() == orderId).toList();
    }

    public List<OrderProductEntity> getOrdersByProductId(int productId) {
        return orderProductRepository.findAll().stream()
                .filter(op -> op.getProductId() == productId)
                .toList();
    }
}
