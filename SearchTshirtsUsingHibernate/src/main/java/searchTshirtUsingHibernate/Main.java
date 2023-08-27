package searchTshirtUsingHibernate;

import java.io.File;
import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public class Main {
	public static void main(String[] args) throws  IOException, CsvValidationException{
		ReadCSV.readCSVdata(); //csv file is parsed into sql table
		ReadMySQL.readMySQL(); //values are read from sql table
		  
	} 
}
