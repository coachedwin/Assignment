package com.nagarro.dao;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.nagarro.model.TshirtModel;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Repository
@Transactional
public class TshirtDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void display() {
		
		
		ClassLoader classLoader = getClass().getClassLoader();			
			File folder= new File("C:\\Users\\sushishreechand\\sushi-sushanshi-shreechand\\AdvancedJava\\AdvanceJava4\\src\\main\\resources\\csvDataFiles");
			File[] files=folder.listFiles();
			for(File file:files) {
				if(file.isFile() && file.getName().endsWith(".csv"))
					FiletoCSV(file); //method to store the data of csv files in the database
					//method to search and display the relevant data from the database
			}
		
		
	}

	
	public void FiletoCSV(File file) //method to store the csv file into the database
	{
	
		try {
	        FileReader filereader = new FileReader(file);
	        CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
			String[] line;
			CSVReader reader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();
			reader.readNext();
			while((line=reader.readNext()) != null) {	
					
						TshirtModel model = new TshirtModel(line[0], line[1], line[2], line[3], line[4], Float.parseFloat(line[5]),Float.parseFloat(line[6]), line[7]);
						Session session=sessionFactory.getCurrentSession();
						
			             session.saveOrUpdate(model);			
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
       
	}
}
