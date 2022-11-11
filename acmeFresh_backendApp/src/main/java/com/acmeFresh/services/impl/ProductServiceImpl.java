package com.acmeFresh.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmeFresh.entities.Product;
import com.acmeFresh.exceptions.ResourceNotFoundException;
import com.acmeFresh.payloads.ProductDto;
import com.acmeFresh.repositories.ProductRepo;
import com.acmeFresh.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo prodcutRepo;
	@Autowired
	private ModelMapper modelMapper;

	// -----------------------------------------------------------------
	@Override
	public ProductDto createProduct(ProductDto pdto) {
		Product p = this.modelMapper.map(pdto, Product.class);

		Product sp = this.prodcutRepo.save(p);

		return this.modelMapper.map(sp, ProductDto.class);

	}

	@Override
	public void deleteProduct(Integer pId) {
		Product p = this.prodcutRepo.findById(pId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "pId", pId));
		this.prodcutRepo.delete(p);

	}

	@Override
	public ProductDto getProduct(Integer pId) {
		Product p = this.prodcutRepo.findById(pId)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "pId", pId));
		return this.modelMapper.map(p, ProductDto.class);

	}

	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> products= this.prodcutRepo.findAll();
		List<ProductDto> pDtoList=products.stream().map(p->this.modelMapper.map(p,ProductDto.class)).collect(Collectors.toList());
		
		return pDtoList;
	}




}
