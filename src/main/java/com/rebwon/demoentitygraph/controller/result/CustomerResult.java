package com.rebwon.demoentitygraph.controller.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResult {
	private Integer customerNumber;
	private String customerName;
	private String phone;
	private String city;
	private String postalCode;
	private String country;
	private Number creditLimit;
}
