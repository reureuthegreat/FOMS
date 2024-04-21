package Cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import FoodItem.FoodItem;

public class CartManager implements ICartManager{
	
	 // Helper method to add an item to the cart
    private void addCartItem(ArrayList<FoodItem> customerMenu, Cart cart) {
        Scanner scanner = new Scanner(System.in);
        try{
        System.out.println("Available Items:");
        for (int i = 0; i < customerMenu.size(); i++) {
            System.out.println((i + 1) + ". " + customerMenu.get(i).getName());
        }
        
        System.out.println("Enter the item number to add:");
        int itemNumber = scanner.nextInt();
        
        if (itemNumber >= 1 && itemNumber <= customerMenu.size()) {
            FoodItem selectedItem = customerMenu.get(itemNumber - 1);
            System.out.println("Enter the quantity:");
            int quantity = scanner.nextInt();
            cart.addItem(selectedItem, quantity);
            System.out.println("Item added to cart.");
        } else {
            throw new IllegalArgumentException("Invalid item number")
        }
        }catch(Exception e){
            System.out.println("Error in adding item " + e.getMessage());
        }finally{
            scanner.close();
        }
    }

    // Helper method to remove an item from the cart
    private void removeCartItem(Cart cart) {
        Scanner scanner = new Scanner(System.in);
        try{
        cart.displayCart();
        System.out.println("Enter the name of the item to remove:");
        String itemName = scanner.nextLine();
        for (Map.Entry<FoodItem, Integer> entry : cart.items.entrySet()) {
            FoodItem item = entry.getKey();
            if (item.getName().equalsIgnoreCase(itemName)) {
                cart.removeItem(item);
                System.out.println("Item removed from cart.");
                return;
            } 
        }
        throw new IllegalArgumentException("Item not found");
        }catch(Exception e){
            System.out.println("Error in removing item "+ e.getMessage());
        }finally{
            scanner.close();
        }
    }

    // Helper method to update the quantity of an item in the cart
    private void updateCartItem(Cart cart) {
        Scanner scanner = new Scanner(System.in);
        try{
        cart.displayCart();
        
        System.out.println("Enter the name of the item to update:");
        String itemName = scanner.nextLine();
        
        for (Map.Entry<FoodItem, Integer> entry : cart.items.entrySet()) {
            FoodItem item = entry.getKey();
            if (item.getName().equalsIgnoreCase(itemName)) {
                System.out.println("Enter the new quantity:");
                int newQuantity = scanner.nextInt();
                cart.updateQuantity(item, newQuantity);
                System.out.println("Quantity updated.");
                return;
            }
        }
        throw new IllegalArgumentException("Item not found");
        }catch(Exception e){
            System.out.println("Error in removing item "+ e.getMessage());
        }finally{
            scanner.close();
        }
    }
	
	public HashMap<FoodItem, Integer> shopping(ArrayList<FoodItem> customerMenu) {
		
		Cart cart = new Cart();
		
		Scanner scanner = new Scanner(System.in);
        boolean done = false;
        while (!done) {
        	System.out.println("+---------------------------------------+");
            System.out.println("|          Cart Management Menu         |");
            System.out.println("+---------------------------------------+");
            System.out.println("| 1. Add Item to Cart                   |");
            System.out.println("| 2. Remove Item from Cart              |");
            System.out.println("| 3. Update Quantity of Item            |");
            System.out.println("| 4. View Cart                          |");
            System.out.println("| 5. Checkout                           |");
            System.out.println("| Press Other Keys to Exit.             |");
            System.out.println("+---------------------------------------+");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addCartItem(customerMenu,cart);
                    break;
                case 2:
                    removeCartItem(cart);
                    break;
                case 3:
                    updateCartItem(cart);
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 5:
                    return cart.items;
                default:
                    System.out.println("Exiting...");
            }
        }
        
        return null;
	}
	
}
