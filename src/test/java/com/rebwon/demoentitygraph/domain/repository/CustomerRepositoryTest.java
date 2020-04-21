package com.rebwon.demoentitygraph.domain.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rebwon.demoentitygraph.domain.Customer;

@DataJpaTest
class CustomerRepositoryTest {
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void findEntityGraph() {
		customerRepository.findWithGraph(1, "customer-with-orders");
	}
}