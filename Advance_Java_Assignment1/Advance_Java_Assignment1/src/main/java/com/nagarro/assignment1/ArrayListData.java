package com.nagarro.assignment1;

import java.io.*;
import java.util.*;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
//fetching data from csv files
public class ArrayListData {

	List<TshirtDetails> list = new ArrayList<TshirtDetails>();
	
	public List<TshirtDetails> getArray()
	{
		CSVParser csvParser = new CSVParserBuilder().withSeparator('|').build();
		
		File dir = new File("C:\\Users\\shivrastogi\\Desktop\\Assignment\\Advance_Java_Assignment1\\Advance_Java_Assignment1\\Advance Java\\Assigment Links\\Assigment Links\\Assignment1\\src\\main\\java\\resources");
		
		File[] file = dir.listFiles();
		
		for(File f : file)
		{
			try{
				CSVReader csvReader = new CSVReaderBuilder(new FileReader(f.getAbsolutePath())).withCSVParser(csvParser).withSkipLines(1).build();
				String []record = null;
				while((record = csvReader.readNext())!=null)
				{
					TshirtDetails tsd2 = new TshirtDetails(record[0],record[1],record[2],record[3],
							record[4],Double.parseDouble(record[5]),Float.parseFloat(record[6]),record[7]);
					
					list.add(tsd2);
				}
				
			}catch(Exception e) {e.printStackTrace();}
		}
		return list;
		//return data in list form
	}
}
