package com.FoodItem;

public interface IFoodItemOperator {

	//Modifiers
	void modifyPrice(FoodItem foodItem);
	void modifyDescription(FoodItem foodItem);
	void modifyCategory(FoodItem foodItem);
	void modifyAvailability(FoodItem foodItem);

	//create a new fooditem
	FoodItem createFoodItem();
}