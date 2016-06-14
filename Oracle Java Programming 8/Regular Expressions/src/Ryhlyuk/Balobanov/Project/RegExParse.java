package Ryhlyuk.Balobanov.Project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExParse {
	
	 
	
	public String readHTML(String fileName)
	{
		String text = "";
		
		try (FileReader fin = new FileReader(fileName);
				BufferedReader bfin = new BufferedReader(fin);
					Scanner in = new Scanner(bfin))
		{
			
			
			while(in.hasNext())
			{
				text += in.nextLine();
			}
			
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		return text;
	}
	
	
	
	public List<Product> getListProduct(String text)
	{
		Pattern patProp = Pattern.compile("(<p class=\"description\">)([0-9,\" a-zA-ZР-пр-џ \\-/,0-9.]+)") ;
			Matcher matProp = patProp.matcher(text);
			
		Pattern patName = Pattern.compile("[р-џР-пa-zA-Z]+\\s+\\w+\\s\\w+\\s\\w+\\s\\(\\w+-\\w+\\)") ;
			Matcher matName = patName.matcher(text);
			
		Pattern patPrice = Pattern.compile("(class=\"price cost\">)([0-9 ]+) (у№э</span>)") ;
			Matcher matPrice = patPrice.matcher(text);
		
			
			
			
			
		List<Product> products = new ArrayList<>();
		
		while(matProp.find() && matName.find() && matPrice.find())
		{
			products.add(getPruduct(matName.group(), matProp.group(2), matPrice.group(2)));
			//System.out.println(matPrice.group(2));
		}
		
		return products;
	}
	
	public void getListName(String text)
	{
		
		Pattern pat = Pattern.compile("(<td>)(\\d+)(</td>)(<td>)(\\w+)(</td>)(<td>)(\\w+)(</td>)") ;
		Matcher mat = pat.matcher(text);
			
		System.out.println("______________________________________________________________");
		System.out.format("|%-10s|\t\t|%-10s|\t\t|%-10s |\n", "Rank", "Male name", "Female name");
		
		while(mat.find())
		{
			System.out.format("|%-10s|\t\t|%-10s|\t\t|%-10s  |\n", mat.group(2), mat.group(5), mat.group(8));
			System.out.println("--------------------------------------------------------------");
		}
		System.out.println("______________________________________________________________");
	}
	
	
	private Product getPruduct (String name, String str, String price)
	{
		Scanner in = new Scanner(str).useDelimiter("/ ");
		List<String> temp = new ArrayList<String>();
		
		while(in.hasNext())
		{
			temp.add(in.next());
		}
		
		return new Product(temp, name, price);
	}
	

}
