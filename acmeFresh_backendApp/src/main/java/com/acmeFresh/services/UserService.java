package com.acmeFresh.services;

import com.acmeFresh.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto, Integer userId);
	UserDto getUserById(Integer userId);
	void deleteUser(Integer userId);
	
	
}
