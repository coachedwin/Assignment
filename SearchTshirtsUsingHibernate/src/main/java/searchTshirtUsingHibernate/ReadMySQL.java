package searchTshirtUsingHibernate;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ReadMySQL {
	public static void readMySQL() {
		Configuration config = new Configuration().configure().addAnnotatedClass(Brand.class);
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		UserInput ui= new UserInput();
		
		Query query = session.createQuery("From Brand where size ='"+ui.getSize()+"' and colour ='"+ui.getColor()+"' and gender ='"+ui.getGender()+"' order by '"+ui.getOutputPreference()+"'");
		List<Brand> brand = query.list();
		
		if(brand.isEmpty())
			System.out.println("we regret to inform you that your prefrence is not available");
		for(Brand b :brand) {
			System.out.println("product id : "+b.getId()+", product name :"+b.getName()+", gender : "+b.getGender()+", color : "+b.getColour()+", price : "+b.getPrice()+", rating : "+b.getRating());
			
		}
		
		
		System.out.println("\n Do you want to enter more details. Y/N");
		Scanner sc = new Scanner(System.in);
		char again = sc.next().toUpperCase().charAt(0);
		if(again=='Y') {
			readMySQL();
		}else {
			System.out.println("Thanks for visiting");
		}
		
		
		//Will Look for New File Even After Program Has Ended
		Runnable r = new Runnable() {
		      public void run() {
		    	  boolean flag = true;
		    	  while (flag) {
		    		  File dir = new File(AssignmentLinks.PATH);
		    		  File[] files = dir.listFiles();
		    		  for (File file: files) {
		    			  String fileName = file.getName();
		    			  System.out.println(fileName);
		    		  }
		    		  try {
		    			  Thread.sleep(2000);
		    		  } catch (InterruptedException e) {
		    			  e.printStackTrace();
		    		  }
		    	  }
		      	}
		    };
		    Thread t = new Thread(r);
		    t.start();
		    System.out.println("Main() program exited already\n");
	}
}
