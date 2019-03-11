//THIS CLASS IS RESPONSIBLE FOR CREATING/OPENING THE FOODLIST FILE AND WRITING NEW INFORMATION
//TO IT

import java.util.*;
import java.lang.*;
import java.io.*;


public class EnteringFoodList {
	private static String s1="FoodList.txt";
	public void entering_name() throws IOException
	{
		BufferedWriter out = new BufferedWriter(new FileWriter(s1,true));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the new food item");
		String foodItem = in.readLine();
		System.out.println("Please enter the primary ingredient of the food item");
		String primaryIngred = in.readLine();
		System.out.println("Please enter the secondary ingredient of the food item");
		String secondIngred = in.readLine();
		String finalEntry = foodItem + "," + primaryIngred + "," + secondIngred;
		//System.out.println(finalEntry);
		
		out.append(finalEntry);
		out.newLine();
		out.close();
		
		
		
	}


    /*public static void main(String args[]) throws IOException
    {
	   EnteringFoodList obj = new EnteringFoodList();
	   obj.entering_name();
    }*/
	   
	   
	
}

