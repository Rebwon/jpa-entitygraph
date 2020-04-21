package com.rebwon.demoentitygraph.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDetailProductId implements Serializable {
	@Column(name = "orderNumber")
	private Integer orderNumber;
	@Column(name = "productCode")
	private String productCode;
}
