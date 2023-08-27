package searchTshirtUsingHibernate;

import java.util.Scanner;

public class UserInput {
	private String color;
    private String size;
	private String gender;
	private String outputPreference;
	Scanner sc=new Scanner(System.in);
	
	
	public String getColor() {
		System.out.println("Enter your color prefrence");
		color = sc.next();
		return color;
	}
	
	public String getSize() {
		System.out.println("Enter your size : S/M/L/XL/XXL");
		size = sc.next();
		return size;
	}
	public String getGender() {
		System.out.println("Enter your gender prefrence : M/F/U");
		gender = sc.next();
		return gender;
	}
	public String getOutputPreference() {
		System.out.println("Output preference(PRICE/RATING/both):");
		outputPreference = sc.next();
		return outputPreference;
	}
}
