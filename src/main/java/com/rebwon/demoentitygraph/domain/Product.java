package com.rebwon.demoentitygraph.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
@NoArgsConstructor
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String productCode;

	private String productName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productLine", referencedColumnName = "productLine")
	private ProductLine productLine;

	private String productScale;
	private String productVendor;
	private String productDescription;
	private Integer quantityInStock;
	private Float buyPrice;
	@Column(name = "MSRP")
	private Float msrp;

	@OneToMany( mappedBy = "product")
	private Set<OrderDetail> orderDetails;
}
