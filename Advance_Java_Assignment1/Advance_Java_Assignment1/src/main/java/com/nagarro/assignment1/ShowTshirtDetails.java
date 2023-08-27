package com.nagarro.assignment1;

import java.util.*;
public class ShowTshirtDetails {
	
	public void showDetails(ArrayList<TshirtDetails> tshirtlist)
	{
		for(TshirtDetails details : tshirtlist)
		{
			System.out.println("-----------------------------------------------------------------------------------------------------------------"
					+ "--------------------------------------------------------------------------------------------------------------------------");
			System.out.print("\t |\t" + details.getId());
			System.out.print("\t |\t" + details.getName());
			System.out.print("\t |\t" + details.getColour());
			System.out.print("\t |\t" + details.getGender());
			System.out.print("\t |\t" + details.getSize());
			System.out.print("\t |\t" + details.getPrice());
			System.out.print("\t |\t" + details.getRating());
			System.out.print("\t |\t" + details.getAvailability());
			System.out.println();
			System.out.println("------------------------------------------------------------------------------------------------"
					+ "----------------------------------------------------------------------------------------------------------------------------------------");
		}
		if(tshirtlist.isEmpty())
			System.out.print("Sorry we don't have Tshirt of this type!");
		
	}

	
}
