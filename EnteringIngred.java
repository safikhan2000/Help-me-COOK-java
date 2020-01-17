//THIS CLASS IS RESPONSIBLE FOR ENTERING A NEW ITEM INTO THE INGREDIENTS FILE


//Demo entry just for testing


import java.util.*;
import java.lang.*;
import java.io.*;


public class EnteringIngred {
	private static String filename = "IngredList.txt";
	public void EnteringIngredList() throws IOException
	{
		BufferedWriter out = new BufferedWriter(new FileWriter(filename,true));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("please enter the ingredients present in the house");
		String ingred = in.readLine();
		System.out.println("Please enter the number of units of the ingredient");
		String units = in.readLine();
		String finalEntry = ingred + "," + units;
		out.append(finalEntry);
		out.newLine();
		out.close();
		
		
	}
	
	public static void main(String args[]) throws IOException
	{
		EnteringIngred obj = new EnteringIngred();
		obj.EnteringIngredList();
		
	}

}
