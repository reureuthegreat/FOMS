package FoodItem;


import java.util.Scanner;


import Category.Category;
import Category.CategoryReader;
import Category.ICategoryReader;
/*
 * FoodItem Class:
 * 
 * -Attributes:
 * 	protected String name;
	protected double price;
	protected String description;
	protected Category category;
	
	-Constructor:
	 FoodItem(String name,double price,String description,Category category) 
	 
	-Methods:
	1. public boolean equals(Object obj)
	Overrides java equals class to make valid comparisons between objects
	
	2. public void display()
	Displays the FoodItem 
	
 */



public class FoodItem{
	
	private final String name;
	private double price;
	private String description;
	private Category category;
	private Boolean availability;
	
	public FoodItem(String name,double price,String description,Category category,Boolean availability) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.availability = availability;
	}
	
	//Getters
	public double getPrice() {
		return price;
	}

	protected String getDescription() {
		return description;
	}

	protected Category getCategory() {
		return category;
	}
	
	public String getName() {
		return name;
	}
	
	public Boolean getAvailability() {
		return availability;
	}
	
	//Setters
	protected void setPrice(double price) {
		this.price = price;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	protected void setCategory(Category category) {
		this.category = category;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	
	@Override
	public boolean equals(Object obj) {
		 if (obj == null || getClass() != obj.getClass()) {
			 return false;
	     }
	     FoodItem other = (FoodItem) obj;
	     return Double.compare(other.price, price) == 0 &&
	                name.equals(other.name) &&
	                description.equals(other.description) && 
	                other.category == category;
	}
	
	public void display(){
		System.out.println("+------------------------------------------+");
		System.out.printf("| Name: %-34s |\n", name);
		System.out.println("+------------------------------------------+");
		System.out.println("Category: "+category);
		System.out.println("Price: $"+price);
		System.out.println("Description: "+description);
		if (availability)
			System.out.println("Item Available");
		else 
			System.out.println("Item Unavailable");
	}

}
