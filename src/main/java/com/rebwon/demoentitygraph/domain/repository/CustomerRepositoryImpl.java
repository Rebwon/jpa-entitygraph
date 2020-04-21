package com.rebwon.demoentitygraph.domain.repository;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rebwon.demoentitygraph.domain.Customer;

@Repository
public class CustomerRepositoryImpl implements BaseRepository<Customer, Integer> {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Customer findWithGraph(Integer id, String graphName) {
		EntityGraph<?> entityGraph = em.getEntityGraph(graphName);
		Map<String, Object> properties = new HashMap<>();
		properties.put("javax.persistence.fetchgraph", entityGraph);
		Customer customer = em.find(Customer.class, id, properties);
		return customer;
	}
}
