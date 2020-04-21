package com.rebwon.demoentitygraph.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orderdetails")
@NoArgsConstructor
@EqualsAndHashCode
public class OrderDetail implements Serializable {
	@EmbeddedId
	private OrderDetailProductId id;

	@MapsId("orderNumber")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber")
	private Order order;

	@MapsId("productCode")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productCode", referencedColumnName = "productCode")
	private Product product;

	private Integer quantityOrdered;
	private BigDecimal priceEach;
	private Integer orderLineNumber;

	public OrderDetail(Order order, Product product){
		this.order = order;
		this.product = product;
		this.id = new OrderDetailProductId(order.getOrderNumber(), product.getProductCode());
	}
}
