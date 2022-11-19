package com.promineotech.whitegown.entity;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
	private Long customer_pk;
	private String first_name;
	private String last_name;
	private BigDecimal budget;
	private Integer reservation_id;

}
