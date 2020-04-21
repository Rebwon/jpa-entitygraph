package com.rebwon.demoentitygraph.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rebwon.demoentitygraph.domain.Customer;
import com.rebwon.demoentitygraph.domain.CustomerRelation;
import com.rebwon.demoentitygraph.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
	private final CustomerRepository customerRepository;

	public Customer getById(Integer id) {
		return this.customerRepository.getOne(id);
	}

	public Customer getCustomerWithGraphById(Integer id, CustomerRelation relation) {
		return this.customerRepository.findWithGraph(id, relation.getName());
	}
}
