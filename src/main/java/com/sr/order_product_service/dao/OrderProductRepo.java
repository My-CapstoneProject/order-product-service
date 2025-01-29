package com.sr.order_product_service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sr.order_product_service.entity.OrderProductEntity;

@Repository
public interface OrderProductRepo extends JpaRepository<OrderProductEntity,Integer>{
	List<OrderProductEntity> findByOrderId(int orderId);

}
