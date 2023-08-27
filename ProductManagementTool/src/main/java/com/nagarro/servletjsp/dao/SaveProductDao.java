package com.nagarro.servletjsp.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
import com.nagarro.servletjsp.pojo.Product;
import com.nagarro.servletjsp.util.ProductDbUtil;

@MultipartConfig(maxFileSize = 1000000)
public class SaveProductDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//static Session session=DbUtil.getSessionFactory().openSession();
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
	public static List<Product> getAllProducts() {
		Session session=ProductDbUtil.getSessionFactory().openSession();
		List<Product> products=new ArrayList<Product>();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from Product");
		products=q.list();	
		tx.commit();
		session.close();
		return products;
		
	}
	public static Product getProductById(String id){
		Session session=ProductDbUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("From Product p where p.id=:id").setParameter("id",id);
		Product product=(Product) q.uniqueResult();
		tx.commit();
		session.close();
		return product;	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Session session=ProductDbUtil.getSessionFactory().openSession();
		Product product=new Product();
		product.setId(request.getParameter("id"));
		
		Query q=session.createQuery("From Product p where p.id=:id").setParameter("id",request.getParameter("id"));
		if(q.uniqueResult()==null) {
		
		product.setTitle(request.getParameter("title"));
		product.setQuantity(request.getParameter("qty"));
		product.setSize(request.getParameter("size"));
		InputStream is=null;
		Part part=request.getPart("img");
		
		String fileName=extractFileName(part);	
		String filePath = fileName ;
		product.setPath(filePath);
		
		is=part.getInputStream();
		byte[] data=new byte[is.available()];
		is.read(data);
		product.setImage(data);		
		Transaction txx=session.beginTransaction();
		session.save(product);		
		txx.commit();
		session.close();
		request.setAttribute("isize", data.length);
		RequestDispatcher rd=request.getRequestDispatcher("ProductManagement.jsp");
		rd.forward(request, response);
		}
		
		
	}

	

	
	

}
