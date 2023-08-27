package searchTshirtUsingHibernate;

import java.io.*;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class ReadCSV {
	//readCSV.readCSVData();
	public static void readCSVdata() throws IOException, CsvValidationException{
		Configuration config = new Configuration().configure().addAnnotatedClass(Brand.class);
		config.configure("hibernate.cfg.xml");
		StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		File dir = new File(AssignmentLinks.PATH); //folder directory where all csv files are stored
		File[] files = dir.listFiles(); //returns array of files in the specified folder
		Reader reader = null; //initiating the value of reader with null

		  
		//fetching all the files from the array of files
		   
		for (File file: files) {
			try {
				reader = new BufferedReader(new FileReader(file));
				CsvToBean<Brand> csvReader = new CsvToBeanBuilder<Brand>(reader).withType(Brand.class).withSeparator('|').build();
				Iterator <Brand> itr = csvReader.iterator();
				while (itr.hasNext()) {
					Brand b= itr.next();
					session.save(b);
				} 
		    } 
		    catch (IOException e) {
		      System.out.println(e);
		    }
		    finally {
		    	if (reader != null) {
		        reader.close();
		    	} 
		    }
		}
		  
	//	tx.commit();
		session.close();
	}
}
