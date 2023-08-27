package com.nagarro.assignment1.input;

import java.io.IOException;
import java.util.Scanner;

import com.nagarro.assignment1.output.Output;

public class Input {

	public static void main(String [] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		
	
		Output obj = new Output();
		
		char ch;
		double i=0;
		int count=0;
		
		do {
			if(count!=0) {
			sc.nextLine();}
			System.out.println("Enter Car Model :");
			String carModel = sc.nextLine();
			
			System.out.println("Enter car type Its Hatchback, Sedan or SUV :");
			String carType = sc.nextLine().toLowerCase();
			
			System.out.println("Enter the type of Insurance Basic or Premimum :");
			String insuranceType = sc.nextLine().toLowerCase();
			
			System.out.println("Enter car cost :");
			long carCost =sc.nextLong();
			
			i=obj.carInsuranceDetails(carModel ,carType ,carCost ,insuranceType );
			if(i!=0) {
			System.out.println("Car Model : " +carModel);
			System.out.println("Car Type : " +carType);
			System.out.println("Car Cost : " +carCost);
			System.out.println("Car Insurance : " +i);
			}
		
			System.out.println("Do you want to enter another car details(Enter y/n) : \n");
			
			ch= sc.next().charAt(0);
			count++;
		}while((ch =='Y') || (ch =='y'));
		
		
	

	}

}
