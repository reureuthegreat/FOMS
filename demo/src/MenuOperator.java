package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import FoodItem.FoodItem;
import FoodItem.FoodItemOperator;

public class MenuOperator implements ICustomerMenu,IManagerMenu{
	

    public void Display_Manager_Menu(Menu menu) {
		try {
            ArrayList<FoodItem> menu_items = menu.getMenu();
            System.out.println("+------------------------------------------+");
            System.out.printf("| Total Items: %-27s |\n", menu_items.size());
            System.out.println("+------------------------------------------+");
            for (int i = 1; i <= menu_items.size(); i++) {
                System.out.println();
                System.out.println("+------------------------------------------+");
                System.out.printf("|Item #%-35s |\n", i);
                menu_items.get(i - 1).display();
            }
        } catch (Exception e) {
            System.out.println("Error displaying manager menu: " + e.getMessage());
        }
	}
    
    public void Display_Customer_Menu(ArrayList<FoodItem> customer_menu) {
		
		try {
            System.out.println("+------------------------------------------+");
            System.out.printf("| Menu Items: %-28s |\n", customer_menu.size());
            System.out.println("+------------------------------------------+");
            for (int i = 1; i <= customer_menu.size(); i++) {
                System.out.println();
                System.out.println("+------------------------------------------+");
                System.out.printf("|Item #%-35s |\n", i);
                customer_menu.get(i - 1).display();
            }
        } catch (Exception e) {
            System.out.println("Error displaying customer menu: " + e.getMessage());
        }
	}
    
    
	//check for duplicated/existing names in the menu
	private boolean check_duplicates(String name,ArrayList<FoodItem> menu) {
		try {
            for (FoodItem foodItem : menu) {
                if (foodItem.getName().equals(name))
                    return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error checking duplicates: " + e.getMessage());
            return false;
        }
	}
		
	public void Add_FoodItems(Menu menu) {
		try {
            FoodItem foodItem = FoodItemOperator.createFoodItem();
			//check if name alredy exists
            if (check_duplicates(foodItem.getName(), menu.getMenu())) {
                menu.addItem(foodItem);
            } else {
                System.out.println("Error! Name already exists!");
            }
        } catch (Exception e) {
            System.out.println("Error adding food item: " + e.getMessage());
        }
	}	
	
	public void Remove_FoodItems(Menu menu) {
		
		Scanner scanner = new Scanner(System.in);
        try {
            int index;
            ArrayList<FoodItem> menu_items = menu.getMenu();

            if (menu_items.size() == 0) {
                System.out.println("No items to remove. Menu is empty.");
                return;
            }

            Display_Manager_Menu(menu);

            do {
                System.out.println("Enter the Index of removing item:" + "1 ~ " + menu_items.size());
                index = scanner.nextInt();
                if (index < 1 || index > menu_items.size()) {
                    System.out.println("Index must be between 1 and " + menu_items.size() + ". Try again.");
                }
            } while (index < 1 || index > menu_items.size());

            FoodItem foodItem = menu_items.get(index - 1);
            menu.removeItem(foodItem);
        } catch (Exception e) {
            System.out.println("Error removing food item: " + e.getMessage());
        } finally {
            scanner.close();
        }
			
	}
	
	
	public void Update_FoodItems(Menu menu) {
		Scanner scanner = new Scanner(System.in);
        try {
            int index;
            ArrayList<FoodItem> menu_items = menu.getMenu();

            if (menu_items.size() == 0) {
                System.out.println("No items to update. Menu is empty.");
                return;
            }

            Display_Manager_Menu(menu);
            System.out.println("");
            System.out.println("");

            do {
                System.out.println("Enter the ordering number of the item to update:" + "1 ~ " + menu_items.size());
                index = scanner.nextInt();
                if (index < 1 || index > menu_items.size()) {
                    System.out.println("Ordering number must be between 1 and " + menu_items.size() + ". Try again.");
                }
            } while (index < 1 || index > menu_items.size());

            FoodItem foodItem = menu_items.get(index - 1);
            menu.updateItem(foodItem);
        } catch (Exception e) {
            System.out.println("Error updating food item: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
	}
    
    
