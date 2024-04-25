package com.Accounts;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.PaymentManagement.PaymentManagement;

public class PaymentManagementApp {
    
    public PaymentManagementApp(){}
    int choice;
    Scanner sc = new Scanner(System.in);
    public void paymentmanagementapp(){
        PaymentManagement PM = new PaymentManagement();
        try {
            System.out.println("==========Manage Payment===========\n" +
                       "1. Add Payment Method\n" +
                       "2. Remove Payment Method\n" +
                       "3. Back\n" +
                       "==========================\n");

            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    sc.nextLine();
                    System.out.println("Enter the Payment Method Name:");
                    String name = sc.nextLine();
                    String Cardnumber = "None";
                    PM.addPaymentMethod(name,Cardnumber);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter the name of the payment method you would like to remove:");
                    name = sc.nextLine();
                    PM.removePaymentMethod(name);
                    break;
                case 3:
                    // Back
                    break;
                default:
                    System.out.println("Please choose a valid option.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.nextLine(); // Consume the invalid input to avoid an infinite loop
        }
    }
}