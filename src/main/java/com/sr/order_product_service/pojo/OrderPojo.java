package com.sr.order_product_service.pojo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderPojo {
	
	public int orderId;
	
	public String orderStatus;

	public LocalDate orderDate;

	public String orderUserId;

	public int orderStoreId;

}

