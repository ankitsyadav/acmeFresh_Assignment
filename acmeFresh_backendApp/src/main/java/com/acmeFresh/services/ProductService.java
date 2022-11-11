package com.acmeFresh.services;

import java.util.List;

import com.acmeFresh.payloads.ProductDto;

public interface ProductService {

	ProductDto createProduct(ProductDto pdto);

	void deleteProduct(Integer pId);

	ProductDto getProduct(Integer pId);
	
	List<ProductDto> getAllProduct();
	
}
