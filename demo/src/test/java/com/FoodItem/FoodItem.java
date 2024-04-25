package com.FoodItem;


import com.Category.Category;
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

/**
 * Represents a food item with attributes such as name, price, description, category, availability, and location.
 */
public class FoodItem{
	
	private final String name;
	private double price;
	private String description;
	private Category category;
	private Boolean availability;
	private String Location;

	/**
	 * Constructs a new FoodItem object with the specified attributes.
	 *
	 * @param name        The name of the food item.
	 * @param price       The price of the food item.
	 * @param description The description of the food item.
	 * @param category    The category of the food item (e.g., Burger, Drink, SideDish, SetMeal).
	 * @param availability The availability status of the food item (true if available, false if unavailable).
	 * @param location    The location or origin of the food item.
	 */
	public FoodItem(String name,double price,String description,Category category,Boolean availability,String Location) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.availability = availability;
		this.Location = Location;
	}
	
	//Getters
	/**
	 * Retrieves the price of the food item.
	 *
	 * @return The price of the food item.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Retrieves the description of the food item.
	 *
	 * @return The description of the food item.
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * Retrieves the category of the food item.
	 *
	 * @return The category of the food item.
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Retrieves the name of the food item.
	 *
	 * @return The name of the food item.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retrieves the availability status of the food item.
	 *
	 * @return True if the food item is available, false otherwise.
	 */
	public Boolean getAvailability() {
		return availability;
	}

	/**
	 * Retrieves the location or origin of the food item.
	 *
	 * @return The location or origin of the food item.
	 */
	public String getLocation() {
		return Location;
	}
	
	//Setters

	/**
	 * Sets the price of the food item.
	 *
	 * @param price The new price of the food item.
	 */
	protected void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Sets the description of the food item.
	 *
	 * @param description The new description of the food item.
	 */
	protected void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the category of the food item.
	 *
	 * @param category The new category of the food item.
	 */
	protected void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * Sets the availability status of the food item.
	 *
	 * @param availability The new availability status of the food item (true if available, false if unavailable).
	 */
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	/**
	 * Sets the location or origin of the food item.
	 *
	 * @param location The new location or origin of the food item.
	 */
	public void setLocation(String location) {
		Location = location;
	}


	/**
	 * Compares this FoodItem object to another object for equality.
	 *
	 * @param obj The object to compare with this FoodItem.
	 * @return True if the objects are equal, false otherwise.
	 */
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

	/**
	 * Displays information about the FoodItem.
	 */
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
