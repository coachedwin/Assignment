package com.nagarro.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.User;
import com.nagarro.repository.RegistrationRepo;
import com.nagarro.service.RegistrationServiceInterface;


@Service
public class RegistrationService implements RegistrationServiceInterface {

	@Autowired
	private RegistrationRepo repo;

	
	public User saveUser(User user) {
		return repo.save(user);
	}

	
	public User fetchUserByEmailId(String emailId) {
		return repo.findByEmailId(emailId);
	}

	
	public Long countAllRegistrated() {
		return repo.count();
	}

}
