package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dao.LoginDao;
import com.nagarro.dao.TshirtDao;
import com.nagarro.model.TshirtModel;
import com.nagarro.repository.SearchData;

@Controller
public class FrontController {
@Autowired
SearchData td;
TshirtModel tm;
@Autowired
TshirtDao tshirt;

@Autowired
LoginDao log;
@RequestMapping("/login")
public String login(@RequestParam("uname") String username,@RequestParam("pass") String password) //Login servlet
{
	tshirt.display();
	String a=log.Login(username,password);
	
	if(a=="True") {
		return "Buy.jsp";
	}
	else {
		
		return "Register.jsp";
	}
}

@RequestMapping("/Register")
public String RegisterUser(@RequestParam("uname") String uname,@RequestParam("pass") String password) //Servlet to register a new user
{
	log.Register(uname, password);
	return "Buy.jsp";
}

@RequestMapping("/datafetch")
public ModelAndView datafetch(@RequestParam("Colour") String color,@RequestParam("size") String size,@RequestParam("gender") String gender,@RequestParam("output") int output)

{
	ModelAndView mv=new ModelAndView();
	
	List<TshirtModel> tm;
	tm=td.Search(color,size,gender,output);

	mv.addObject("tm",tm);
	mv.setViewName("table.jsp");
	return mv;
	}
}