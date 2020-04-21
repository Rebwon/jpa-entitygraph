package com.rebwon.demoentitygraph.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rebwon.demoentitygraph.domain.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
	@Mock private CustomerRepository customerRepository;
	private CustomerService customerService;

	@BeforeEach
	void setUp() {
		customerService = new CustomerService(customerRepository);
	}


}