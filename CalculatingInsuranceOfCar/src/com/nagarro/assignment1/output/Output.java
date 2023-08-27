package com.nagarro.assignment1.output;

import java.io.IOException;

import com.nagarro.assignment1.calculateInsurance.CalculateInsurance;

public class Output {
	
	public double carInsuranceDetails(String carModel ,String carType ,double carCost , String insuranceType )throws IOException {
		String insuranceType1 = "basic";
		String insuranceType2 = "premimum";
		String carType1 ="hatchback";
		String carType2 ="sedan";
		String carType3 ="suv";
		CalculateInsurance ci =new CalculateInsurance();
		double answer=0;
		if(carCost<=0) {
			System.out.println("Kindly Enter valid Car Cost");
			return 0;
		}
		

		if(insuranceType.equals(insuranceType1)) {
			if(carType.equals(carType1)) {
				answer =ci.hatchbackInsurance(carCost);
			
			}
			else if(carType.equals(carType2)) {
				answer =ci.sedan(carCost);
		
			}
			else
			{
				answer =ci.suv(carCost);
			
			}
			
			
		}
		else {
			if(carType.equals(carType1)) {
				answer =ci.hatchbackInsurance(carCost);
				answer = answer + answer*20/100;
				
			}
			else if(carType.equals(carType2)) {
				answer =ci.sedan(carCost);
				answer = answer + answer*20/100;
				
			}
			else
			{
				answer =ci.suv(carCost);

				answer = answer + answer*20/100;
				
			}
			
			
		}
		//System.out.println("Car Model : "+carModel + "Price : "+ carCost + "Total Insurance : "+ answer);
		if(((insuranceType.equals(insuranceType1))||(insuranceType.equals(insuranceType2)))&&
				(((carType.equals(carType1))||(carType.equals(carType2))||(carType.equals(carType3))))){
		return answer;}
		else {
			System.out.println("Kindly Enter valid details");
			return 0;
		}
		}
	
		
		
		}
	
	
	
	

	 

