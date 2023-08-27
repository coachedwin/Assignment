package com.nagarro.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.nagarro.entity.User;

import org.springframework.security.core.userdetails.*;


public class UserInfo implements UserDetails {

	private static final long serialVersionUID = 1L;
	private User user;

	public UserInfo(User user) {
		super();
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getEmailId());
		return List.of(simpleGrantedAuthority);
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getEmailId();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public String userName() {
		return user.getFirstName()+" "+user.getLastName();
	}
}