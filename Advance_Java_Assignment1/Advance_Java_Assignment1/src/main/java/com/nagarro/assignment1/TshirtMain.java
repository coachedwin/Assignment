package com.nagarro.assignment1;

import java.io.FileNotFoundException;
import java.util.*;
public class TshirtMain {

	public static void main(String[] args) {
		
		//object for getting data from arraylistdata class
		
		ArrayListData data = new ArrayListData();
		
		Scanner scan = new Scanner(System.in);
		String colour , size, gender;
		int preference;
		
		
		try {
		
		System.out.println("Enter Colour of the Tshirt");
		colour = scan.nextLine();
		
		System.out.println("Enter Gender as M-Male/F-Female/U-Unisex");
		gender = scan.nextLine();
		
		
		System.out.println("Enter Size of the Tshirt as S/M/L/XL/XXL");
		size = scan.nextLine();
		
		
		System.out.println("Enter Output Preference \n1.Price\n2.Rating\n3.Price & Rating");
		preference = scan.nextInt();
		
		
		//for search and compare
		SearchTshirt ts = new SearchTshirt();
		try 
		{
			ts.searchTshirt(data.getArray(),colour,size,gender);
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		ts.sortValues(preference);
		scan.close();
		
		
		//closing above tryblock
		}catch(InputMismatchException e){System.out.println("Wrong Entry ! Please choose as suggested!");}
		
	}

}
