package Ryhlyuk.Balobanov.Project;

import java.util.List;

public class Product {

	private List<String> nachinka; 
	private String name;
	private String price;
	/**
	 * @param name
	 * @param price
	 * @param model
	 * @param processor
	 */

	public Product(List<String> p, String name, String price)
	{
		nachinka = p;
		this.name = name;
		this.price = price;
	}
	/**
	 * @return the name
	 */
	
	public String toString()
	{
		System.out.println(name+ " Цена: " + price);
		for (int i = 0; i < nachinka.size(); i++) {
			System.out.print(nachinka.get(i) + " ");
		}
		
		System.out.println();
		return "";
	}

}
