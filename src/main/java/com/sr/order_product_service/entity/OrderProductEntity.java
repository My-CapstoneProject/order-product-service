package com.sr.order_product_service.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="order_product_details")
public class OrderProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_product_id")
	public int orderProductId;
	
	@Column(name="order_id")
	public int orderId;
	
	@Column(name="product_id")
	public int productId;
	
	@Column(name="sales_quantity")
	public int sales_quantity;

}
