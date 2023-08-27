package searchTshirtUsingHibernate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Component
@Controller
public class Login<HttpServletResponse, HttpServletRequest> {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@RequestMapping("/authenticate")
	public String authenticate(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//LoginPOJO user = new LoginPOJO();
		Session session = sessionFactory.getCurrentSession();
		
		File dir = new File("C:\\Users\\shivrastogi\\eclipse-workspace\\SearchTshirtsUsingHibernate\\src\\main\\resources\\csvDataFiles"); //folder directory where all csv files are stored
		  File[] files = dir.listFiles(); //returns array of files in the specified folder
		  Reader reader = null; //initiating the value of reader with null

		  /*
		   * fetching all the files from the array of files
		   */
		  for (File file: files) {
		    try {
		      reader = new BufferedReader(new FileReader(file));
		      CsvToBean<LoginPOJO> csvReader = new CsvToBeanBuilder<LoginPOJO> (reader).withType(LoginPOJO.class).withSeparator('|').build();
		      Iterator<LoginPOJO> itr = csvReader.iterator();
		      while (itr.hasNext()) {
		    	LoginPOJO p1= itr.next();
		        session.save(p1);
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
		
		return "search.jsp";
	}
}
