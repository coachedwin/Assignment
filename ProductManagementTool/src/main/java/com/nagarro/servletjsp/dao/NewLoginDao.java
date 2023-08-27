package com.nagarro.servletjsp.dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.nagarro.servletjsp.pojo.Login;
import com.nagarro.servletjsp.util.UserDbUtil;

/**
 * Servlet implementation class NewLoginDao
 */
public class NewLoginDao extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session=UserDbUtil.getSessionFactory().openSession();
		Login login=new Login();
		String user=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		Transaction tx=session.beginTransaction();
		Criteria cri=session.createCriteria(Login.class);
		cri.add(Restrictions.ilike("user",user ));

			login.setUser(user);			
			login.setPwd(pwd);
			session.save(login);
			tx.commit();
			session.close();
			RequestDispatcher rd=request.getRequestDispatcher("LoginDaoPath");
			rd.forward(request, response);
		}
	
}
