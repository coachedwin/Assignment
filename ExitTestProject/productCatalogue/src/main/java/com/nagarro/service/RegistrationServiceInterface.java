package com.nagarro.service;

import com.nagarro.entity.User;

public interface RegistrationServiceInterface {

	public User saveUser(User user);
	
	public User fetchUserByEmailId(String emailId);
	
	public Long countAllRegistrated();
}
