package com.acmeFresh.controllers;

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
import com.acmeFresh.payloads.UserDto;
import com.acmeFresh.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService uService;

//	post -create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createdUserDto = this.uService.createUser(userDto);
		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);

	}

//	delete - delete user

	@DeleteMapping("/{userId}")
	@ApiOperation(value = "Update registration detail", authorizations = { @Authorization(value = "basicAuth") })
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {

		this.uService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted succesfully", true), HttpStatus.OK);
	}

//get user

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId) {
		UserDto userDto = this.uService.getUserById(userId);
		return ResponseEntity.ok(userDto);
	}

}
