package com.rebwon.demoentitygraph.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rebwon.demoentitygraph.controller.result.CustomerResult;
import com.rebwon.demoentitygraph.controller.result.CustomerWithOrdersResult;
import com.rebwon.demoentitygraph.controller.result.OrderDetailResult;
import com.rebwon.demoentitygraph.controller.result.OrderResult;
import com.rebwon.demoentitygraph.controller.result.OrderWithDetailResult;
import com.rebwon.demoentitygraph.domain.Customer;
import com.rebwon.demoentitygraph.domain.CustomerRelation;
import com.rebwon.demoentitygraph.service.CustomerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService customerService;
	private final ModelMapper modelMapper;

	@GetMapping("/{id}")
	public CustomerResult getCustomer(@PathVariable("id") Integer id){
		Customer customer = customerService.getById(id);
		return modelMapper.map(customer, CustomerResult.class);
	}

	@GetMapping("/{id}/with-orders")
	public CustomerWithOrdersResult getCustomerAndOrders(@PathVariable("id") Integer id){
		Customer customer = customerService.getCustomerWithGraphById(id, CustomerRelation.CUSTOMER_WITH_ORDERS);
		CustomerWithOrdersResult customerWithOrders = modelMapper.map(customer, CustomerWithOrdersResult.class);

		List<OrderResult> orders = customer.getOrders().stream()
			.map(order -> modelMapper.map(order, OrderResult.class))
			.collect(Collectors.toList());

		customerWithOrders.setOrders(orders);
		return customerWithOrders;
	}

	@GetMapping("/{id}/with-orders-and-details")
	public CustomerWithOrdersResult getCustomerWithOrdersAndDetails(@PathVariable("id") Integer id){
		Customer customer = customerService.getCustomerWithGraphById(id, CustomerRelation.CUSTOMER_WITH_ORDERS_AND_DETAILS);
		CustomerWithOrdersResult customerDto = modelMapper.map(customer, CustomerWithOrdersResult.class);

		List<OrderResult> orders = customer.getOrders().stream()
			.map(order -> {
				OrderWithDetailResult orderWithDetails = modelMapper.map(order, OrderWithDetailResult.class);
				List<OrderDetailResult> orderDetails = order.getOrderDetail().stream().map(orderDetail -> {

					OrderDetailResult orderDetailDto = new OrderDetailResult();
					orderDetailDto.setOrderLineNumber(orderDetail.getOrderLineNumber());
					orderDetailDto.setPriceEach(orderDetail.getPriceEach());
					orderDetailDto.setProductCode(orderDetail.getProduct().getProductCode());
					orderDetailDto.setQuantityOrdered(orderDetail.getQuantityOrdered());
					return orderDetailDto;
				}).collect(Collectors.toList());

				orderWithDetails.setOrderDetails(orderDetails);
				return orderWithDetails;
			}).collect(Collectors.toList());

		customerDto.setOrders(orders);
		return customerDto;
	}
}
