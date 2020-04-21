package com.rebwon.demoentitygraph.controller.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailResult {
	private String productCode;
	private Integer quantityOrdered;
	private Number priceEach;
	private Integer orderLineNumber;
}
