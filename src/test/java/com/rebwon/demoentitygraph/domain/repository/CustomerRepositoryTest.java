package com.rebwon.demoentitygraph.domain.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CustomerRepositoryTest {
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void findEntityGraph() {
		customerRepository.findWithGraph(1, "customer-with-orders");
	}

	@Test
	void findEntityGraphSubGraph() {
		customerRepository.findWithGraph(2, "customer-with-orders-and-details");
	}
}