package com.rebwon.demoentitygraph.controller.result;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerWithOrdersResult extends CustomerResult{
	private List<OrderResult> orders;

	public CustomerWithOrdersResult() {
		super();
	}
}
