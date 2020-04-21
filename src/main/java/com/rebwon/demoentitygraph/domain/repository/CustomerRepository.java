package com.rebwon.demoentitygraph.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rebwon.demoentitygraph.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>, BaseRepository<Customer, Integer> {
}
