package com.nagarro.servletjsp.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Login{
	@Id
	private String user;
	private String pwd;
	
	public Login() {}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

	@Override
	public String toString() {
		return "Login [user=" + user + ", pwd=" + pwd + "]";
	}
	
	
	
}
