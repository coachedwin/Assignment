package com.nagarro.servletjsp.dao;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.servletjsp.util.ProductDbUtil;

@MultipartConfig(maxFileSize = 1000000)
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Session session=ProductDbUtil.getSessionFactory().openSession();
		InputStream is=null;
		Part part=request.getPart("imge");	
		//System.out.println(part);
		String fileName=extractFileName(part);	
		String filePath = fileName;
		is=part.getInputStream();
		byte[] data=new byte[is.available()];
		is.read(data);
		Query q=session.createQuery("update Product as p set p.title=:title,p.quantity=:qty,p.size=:size,p.path=:path,p.image=:img where p.id=:id").setParameter("title",request.getParameter("title")).setParameter("qty",request.getParameter("qty")).setParameter("size",request.getParameter("size")).setParameter("path",filePath).setParameter("img",data).setParameter("id",request.getParameter("id"));
		q.executeUpdate();
		Transaction tx=session.beginTransaction();
		tx.commit();
		session.close();
		RequestDispatcher rd=request.getRequestDispatcher("ProductManagement.jsp");
		rd.forward(request, response);
	}

}
