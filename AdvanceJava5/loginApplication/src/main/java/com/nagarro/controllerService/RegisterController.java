package com.nagarro.controllerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.dao.RegisterDao;


@Controller
public class RegisterController {
		
		@Autowired
		RegisterDao registerDao;
		@RequestMapping(path="/register" ,method=RequestMethod.POST)
		public String register(@RequestParam("username") String username,@RequestParam("password") String password) {
			System.out.println(username+" : "+password);
			registerDao.saveUser(username, password);
			return "index.jsp";
		}
	
}
