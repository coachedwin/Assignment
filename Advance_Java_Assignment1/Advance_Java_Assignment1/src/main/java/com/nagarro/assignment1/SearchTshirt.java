package com.nagarro.assignment1;

import java.io.*;
import java.util.*;
public class SearchTshirt {
	
	ArrayList<TshirtDetails> list = new ArrayList<TshirtDetails>();
	
	ShowTshirtDetails show = new ShowTshirtDetails();
	
	//method for comparing data 
	
	public void searchTshirt(List<TshirtDetails> list1, String colour, String size, String gender)throws FileNotFoundException
	{
		for(TshirtDetails tsd : list1)
		{
			if( tsd.getColour().equalsIgnoreCase(colour) && tsd.getSize().equalsIgnoreCase(size) && tsd.getGender().equalsIgnoreCase(gender)
					&& tsd.getAvailability().equalsIgnoreCase("Y"))
			{
				TshirtDetails newtsd = new TshirtDetails(tsd.getId(),tsd.getName(),tsd.getColour(),tsd.getGender(),
						tsd.getSize(),tsd.getPrice(),tsd.getRating(),tsd.getAvailability());
			
			list.add(newtsd);
			}
		}
		
	}
	
	
	//function for sorting by price and rating and both
	public void sortValues(int preference)
	{
		if(preference == 1)//sorting by price
		{
			Collections.sort(list, new Comparator<TshirtDetails>() {
					
				public int compare(TshirtDetails o1, TshirtDetails o2) {
					
					return (int)(o1.getPrice()-o2.getPrice());}
			});
		}
		else if(preference == 2)//sorting by rating
		{
			Collections.sort(list, new Comparator<TshirtDetails>() {
					
				public int compare(TshirtDetails o1, TshirtDetails o2) {
					
					return (int)(o2.getRating()-o1.getRating());}
			});
		}
		
		else if(preference == 3)//sorting by both price and rating
		{
			Collections.sort(list, new Comparator<TshirtDetails>() {
				
				public int compare(TshirtDetails o1, TshirtDetails o2) {
					
					 return (int) (((o1.getPrice()-o2.getPrice()) == 0)?((o2.getRating() - o1.getRating())):(o1.getPrice()-o2.getPrice()));}
				
			});
		}
		
		else 
		{
			System.out.println("You have entered the wrong choice!");
			return ;
		}
		show.showDetails(list);
		
	}
	
}
