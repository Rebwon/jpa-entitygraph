package com.rebwon.demoentitygraph.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedEntityGraphs({
	@NamedEntityGraph(
		name = "customer-with-orders",
		attributeNodes = {
			@NamedAttributeNode("orders")
		}

	),
	@NamedEntityGraph(
		name = "customer-with-orders-and-details",
		attributeNodes = {
			@NamedAttributeNode(value = "orders", subgraph = "order-details"),
		},

		subgraphs = {@NamedSubgraph(
			name = "order-details",
			attributeNodes = {
				@NamedAttributeNode("orderDetail")
			}
		)}
	)
})

@Entity
@Getter
@Setter
@Table(name = "customers")
@NoArgsConstructor
public class Customer implements Serializable {
	@Id
	@NotNull
	private Integer customerNumber;

	private String customerName;
	private String contactLastName;
	private String contactFirstName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private Integer salesRepEmployeeNumber;
	private Float creditLimit;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Set<Order> orders;
}
