package com.Cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import com.FoodItem.FoodItem;

/**
 * Represents a shopping cart that implements the IShoppingCart interface.
 */
public class ShoppingCart implements IShoppingCart{

    // Helper method to add an item to the cart
    /**
     * Adds a specified FoodItem to the cart based on customer's menu.
     *
     * @param customerMenu An ArrayList of FoodItem objects representing the customer's menu.
     * @param cart         The Cart object representing the shopping cart.
     * @return True if the item was successfully added, false otherwise.
     */
    private boolean addCartItem(ArrayList<FoodItem> customerMenu, Cart cart) {
        Scanner scanner = new Scanner(System.in);

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
            return true;
        } else {
            System.out.println("Invalid item number.");
            return false;
        }
    }

    // Helper method to remove an item from the cart
    /**
     * Removes a specified item from the cart based on its name.
     *
     * @param cart The Cart object representing the shopping cart.
     */
    private void removeCartItem(Cart cart) {
        Scanner scanner = new Scanner(System.in);

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
        System.out.println("Item not found in cart.");
    }

    // Helper method to update the quantity of an item in the cart
    /**
     * Updates the quantity of a specified item in the cart based on its name.
     *
     * @param cart The Cart object representing the shopping cart.
     */
    private void updateCartItem(Cart cart) {
        Scanner scanner = new Scanner(System.in);
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
        System.out.println("Item not found in cart.");
    }

    /**
     * Creates a shopping cart based on the customer's menu of FoodItems and provides a menu for cart management.
     *
     * @param customerMenu An ArrayList of FoodItem objects representing the customer's menu.
     * @return A HashMap representing the shopping cart with FoodItems and their quantities if checkout is completed, null otherwise.
     */
    @Override
    public HashMap<FoodItem, Integer> shopping(ArrayList<FoodItem> customerMenu) {

        Cart cart = new Cart();

        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        boolean addeditem = false;
        while (!done) {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");

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
                    if(addCartItem(customerMenu,cart)){
                        addeditem = true;
                    }
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
                    if(addeditem == true){
                        return cart.items;
                    }
                    System.out.println("No items added!");
                    break;
                default:
                    done = true;
                    System.out.println("Exiting...");
            }
        }

        return null;
    }

}