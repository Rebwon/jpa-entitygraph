package com.rebwon.demoentitygraph.controller.result;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderWithDetailResult extends OrderResult {
	private List<OrderDetailResult> orderDetails;

	public OrderWithDetailResult() {
		super();
	}
}
