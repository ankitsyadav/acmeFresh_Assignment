package com.acmeFresh.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acmeFresh.payloads.ApiResponse;
import com.acmeFresh.payloads.ProductDto;
import com.acmeFresh.services.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService pService;

//	post -create user
	@PostMapping("/")
	public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto pDto) {
		ProductDto cPDto = this.pService.createProduct(pDto);
		return new ResponseEntity<>(cPDto, HttpStatus.CREATED);

	}

//	delete - delete user

	@DeleteMapping("/{pId}")
	@ApiOperation(value = "Update registration detail", authorizations = { @Authorization(value = "basicAuth") })
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer pId) {

		this.pService.deleteProduct(pId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted succesfully", true), HttpStatus.OK);
	}

//get user

	@GetMapping("/{pId}")
	@ApiOperation(value = "Update registration detail", authorizations = { @Authorization(value = "basicAuth") })
	public ResponseEntity<ProductDto> getProduct(@PathVariable Integer pId) {
		ProductDto pDto = this.pService.getProduct(pId);
		return ResponseEntity.ok(pDto);
	}

	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		return ResponseEntity.ok(this.pService.getAllProduct());
	}

}
