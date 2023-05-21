package com.example.demo.services;

import com.example.demo.model.UserDtls;

public interface UserService {

	public UserDtls createUser(UserDtls user);
	public boolean checkEmail(String email);
	
}
