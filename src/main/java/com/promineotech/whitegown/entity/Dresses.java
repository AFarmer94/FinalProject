package com.promineotech.whitegown.entity;

import java.math.BigDecimal;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dresses {
	private Long dress_pk;
	private Long customer_fk;
	private Designer designer;
	private Color color;
	private Boolean reservation;
	private BigDecimal price;

	public int compareTo(Dresses that) {
		//@formatter:off
			return Comparator
					.comparing(Dresses::getDesigner)
					.thenComparing(Dresses::getColor)
					.thenComparing(Dresses::getPrice)
					.compare(this, that);
			
			//@formatter:on
	}
}
