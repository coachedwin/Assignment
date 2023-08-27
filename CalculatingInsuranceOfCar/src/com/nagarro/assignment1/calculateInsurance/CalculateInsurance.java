package com.nagarro.assignment1.calculateInsurance;

public class CalculateInsurance {
	
	
	public double hatchbackInsurance(double carCost) {
		double insurance = 0;
		insurance =(carCost*5)/100; 
		return insurance;
			
	}
	
	public double sedan(double carCost) {
		double insurance = 0;
		insurance =(carCost*8)/100; 
		return insurance;
			
	}
	
	public double suv(double carCost) {
		double insurance = 0;
		insurance =(carCost*10)/100; 
		return insurance;
			
	}
	
	
	
	
	

}
