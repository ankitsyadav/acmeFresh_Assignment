package com.acmeFresh.payloads;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ProductDto {

	private Integer productId;
	
	@NotBlank
	private String productName;
	
}
