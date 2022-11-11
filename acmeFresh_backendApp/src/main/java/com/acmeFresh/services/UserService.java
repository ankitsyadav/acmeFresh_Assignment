package com.acmeFresh.services;

import com.acmeFresh.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);
	UserDto getUserById(Integer userId);
	void deleteUser(Integer userId);
	
	
}
