package com.rebwon.demoentitygraph.controller.result;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResult {
	private Integer orderNumber;
	private LocalDate orderDate;
	private LocalDate requiredDate;
	private LocalDate shippedDate;
	private String status;
	private String comments;
}
