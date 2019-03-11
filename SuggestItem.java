//THIS FILE IS RESPONSIBLE FOR GENERATING A NEW FOOD ITEM AND MODIFYING THE 
//INGREDIENTS LIST

import java.util.*;
import java.io.*;


public class SuggestItem {
	
	private static String filename_FOOD = "FoodList.txt";
	private static String filename_INGRED = "IngredList.txt";
	
	public void suggestion() throws IOException,FileNotFoundException
	{
		BufferedReader bfood = new BufferedReader(new FileReader(filename_FOOD));
		BufferedReader bingred = new BufferedReader(new FileReader(filename_INGRED));
		//FIRST WE WILL READ THE ENTIRE FOOD ITEMS FILE INTO A LINKED LIST
		List<String> lfood = new LinkedList<String>();
		String sfoodtemp;
		while((sfoodtemp = bfood.readLine())!= null)
		{
			lfood.add(sfoodtemp);
			//System.out.println(sfoodtemp);
		}
		
		//NEXT WE WILL READ THE ENTIRE INGREDIENTS FILE INTO A LINKED LIST
		List<String> lingred = new LinkedList<String>();
		String singredtemp;
		while((singredtemp = bingred.readLine()) != null)
		{
			lingred.add(singredtemp);
			//System.out.println(singredtemp);
		}
		
		
		bfood.close();
		bingred.close();
		
		/* driver steps
		System.out.println("we are going to print the entire files as a list below");
		System.out.println("the foods file is :" + lfood);
		System.out.println("the ingredients file is :" + lingred);*/
		
		
		while(true)
		{
		// NOW WE GENERATE A RANDOM INTEGER TO CHOOSE FROM THE FOODS LIST HERE
		Random rand = new Random();
		int randomValue = rand.nextInt(lfood.size()-1);
		//System.out.println(randomValue);
		//break;
		
		
		//AFTER GENERATING A RANDOM INTEGER IN THE GIVEN RANGE, WE WILL STORE THE CORRESPONDING
		//RECORD INTO VARIABLES
		String chooseTemp = lfood.get(randomValue);
		StringTokenizer str = new StringTokenizer(chooseTemp,",");
		String chooseFood = str.nextToken();
		String choosePrimaryIngred = str.nextToken();
		String chooseSecondaryIngred = str.nextToken();
		
		//NOW THE STRING IS SPLIT INTO RESPECTIVE COMPONENTS
		//WE WILL NOW SPLIT THE INGREDIENTS FILE ITERATIVELY AND SEARCH IF THE PRIMARY INGREDIENT
		//IS PRESENT OR NOT
		int flag=0;  //set this when primary ingredient is present
		int countForPrim=-1;   //counter for primary ingredient
		int countForSec=-1;    //counter for secondary ingredient
		for (int i = 0; i < lingred.size()-1; i++)
		{
			String stringIngred = lingred.get(i);
			//System.out.println(lingred.size());
			StringTokenizer str1 = new StringTokenizer(stringIngred,",");
			String ingredName = str1.nextToken();
			int ingredCount = Integer.parseInt(str1.nextToken());
			countForPrim++;
			if(choosePrimaryIngred.equals(ingredName))
			{
				flag=1;
				break;
			}
		}
		if(flag == 0)  //if primary ingredient is not present then continue
			continue;
		
		//NOW AFTER SEARCHING FOR PRIMARY INGREDIENT IF THE PRIMARY INGREDIENT IS NOT PRESENT
		//THEN WE HAVE TO GENERATE A RANDOM INTEGER AGAIN ELSE WE SEARCH FOR SECONDARY 
		//INGREDIENT
		int finalPresent=0; //set this only when the item is to be selected finally
		if(flag==1)
		{
			for (int i = 0; i < lingred.size()-1; i++)
			{
				//SEARCHING FOR SECONDARY INGREDIENT
				String stringIngred = lingred.get(i);
				StringTokenizer str1 = new StringTokenizer(stringIngred,",");
				String ingredName = str1.nextToken();
				int ingredCount = Integer.parseInt(str1.nextToken());
				countForSec++;
				if(chooseSecondaryIngred.equals(ingredName))
				{
					finalPresent = 1;
					break;
				}
			}
		}
		//System.out.println("the count of prim and sec is  " + countForPrim + countForSec);
		if(finalPresent == 0) //if the secondary ingredient is not present then continue
			continue;
		
		//IF THE SECONDARY INGREDIENT IS ALSO PRESENT THEN UPDATE THE UNITS PART OF THE 
		//INGREDIENT AND WRITING TO THE FILE AGAIN
		if(finalPresent==1)
		{
			System.out.println("The food item selected for you is :");
		    System.out.println(chooseFood);
		    for(int i=0;i<lingred.size()-1;i++)
		    {
		    	if(i==countForPrim)  //update the primary ingredient
		    	{
		    		String strtemp = lingred.get(i);
		    		StringTokenizer strr = new StringTokenizer(strtemp,",");
		    		String ingredName = strr.nextToken();
		    		int ingredCount = Integer.parseInt(strr.nextToken());
		    		ingredCount--;
		    		if(ingredCount == 0)
		    		{
		    			lingred.remove(i);
		    			if(countForPrim<countForSec)
		    				countForSec--;
		    		}
		    		else
		    		{
		    			String ingredCount1 = Integer.toString(ingredCount);
		    			String sfinal = ingredName + "," + ingredCount1;
		    			lingred.remove(i);
		    			lingred.add(i,sfinal);
		    		}
		    	}
		    	
		    	if(i==countForSec) //update the secondary ingredient
		    	{
		    		String strtemp = lingred.get(i);
		    		StringTokenizer strr = new StringTokenizer(strtemp,",");
		    		String ingredName = strr.nextToken();
		    		int ingredCount = Integer.parseInt(strr.nextToken());
		    		ingredCount--;
		    		if(ingredCount == 0)
		    		{
		    			lingred.remove(i);
		    			
		    		}
		    		else
		    		{
		    			String ingredCount1 = Integer.toString(ingredCount);
		    			String sfinal = ingredName + "," + ingredCount1;
		    			lingred.remove(i);
		    			lingred.add(i,sfinal);
		    		}
		    	}
		    }
		    //WRITING THE LIST BACK TO THE FILE
		    BufferedWriter out = new BufferedWriter(new FileWriter(filename_INGRED));
		    for(String strr : lingred)
		    {
		    	out.write(strr);
		    	out.newLine();
		    }
		    out.close();
		    break;
		
		}    
		}
		
	}

	public static void main(String args[]) throws FileNotFoundException, IOException, NoSuchElementException
	{
		SuggestItem sg = new SuggestItem();
		sg.suggestion();
	}
}
