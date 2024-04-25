package com.FoodItem;

public interface IFoodItemOperator {

	/**
	 * Modifies the price of a FoodItem.
	 *
	 * @param foodItem The FoodItem whose price will be modified.
	 */
	//Modifiers
	void modifyPrice(FoodItem foodItem);

	/**
	 * Modifies the description of a FoodItem.
	 *
	 * @param foodItem The FoodItem whose description will be modified.
	 */
	void modifyDescription(FoodItem foodItem);

	/**
	 * Modifies the category of a FoodItem.
	 *
	 * @param foodItem The FoodItem whose category will be modified.
	 */
	void modifyCategory(FoodItem foodItem);

	/**
	 * Modifies the availability status of a FoodItem.
	 *
	 * @param foodItem The FoodItem whose availability status will be modified.
	 */
	void modifyAvailability(FoodItem foodItem);

}