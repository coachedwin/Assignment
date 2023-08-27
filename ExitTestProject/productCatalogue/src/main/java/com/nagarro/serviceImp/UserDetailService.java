package com.nagarro.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.nagarro.entity.User;
import com.nagarro.model.UserInfo;


@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private RegistrationService repository;

	public UserInfo loadUserByUsername(String emailId) throws UsernameNotFoundException {
		

		final User user = this.repository.fetchUserByEmailId(emailId);
		if (user == null) {
			return null;
		} else {
			return new UserInfo(user);
		}
	}

}