package com.Menu;

/**
 * Represents an interface for managing a menu as a manager.
 */
public interface IManagerMenu {

	/**
	 * Displays the manager menu.
	 *
	 * @param menu The Menu object representing the menu to be managed.
	 */
	void Display_Manager_Menu(Menu menu);

	/**
	 * Adds new FoodItems to the menu.
	 *
	 * @param menu The Menu object to which FoodItems will be added.
	 */
	void Add_FoodItems(Menu menu);

	/**
	 * Removes FoodItems from the menu.
	 *
	 * @param menu The Menu object from which FoodItems will be removed.
	 */
	void Remove_FoodItems(Menu menu);

	/**
	 * Updates existing FoodItems in the menu.
	 *
	 * @param menu The Menu object in which FoodItems will be updated.
	 */
	void Update_FoodItems(Menu menu);
}
