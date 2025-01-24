package com.sr.order_product_service.pojo;

import com.sr.order_product_service.entity.OrderProductEntity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderProductPojo {
	
	public int orderProductId;
	
	public int orderId;

	public int productId;

	public int sales_quantity;

}
