package com.rebwon.demoentitygraph.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "productlines")
@NoArgsConstructor
public class ProductLine implements Serializable {
	@Id
	private String productLine;
	private String textDescription;
	private String htmlDescription;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] image;
}
