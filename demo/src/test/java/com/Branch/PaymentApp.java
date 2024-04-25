package com.Branch;

import com.PaymentManagement.*;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents a Payment Application for processing payments using different payment methods.
 */
public class PaymentApp {
    /**
     * Constructs a PaymentApp object.
     */
    public PaymentApp(){}
    int choice, numOfPaymentMethods;
    PaymentManagement PM = PaymentManagement.getInstance();

    /**
     * Process a payment with the specified amount using various payment methods.
     *
     * @param amount The amount to be paid.
     * @return true if the payment is successful, otherwise false.
     */
    public boolean paymentapp(double amount) {
        Scanner sc = new Scanner(System.in);
        int quit;

        do {
            System.out.println("=================Choose your Payment Type=================");
            numOfPaymentMethods = PM.displayPaymentMethods();
            quit = numOfPaymentMethods+1;
            System.out.println("======================================================================\n");
            System.out.println("Please enter the number of your selection: ");
            try {
                choice = sc.nextInt();
                if (choice == 1) {
                    try {
                        sc.nextLine();
                        System.out.println("Enter your Credit Card Number: ");
                        String CardNum = sc.nextLine();
                        System.out.println("Enter the Expiry Date: ");
                        String ExpDate = sc.nextLine();
                        System.out.println("Enter your Card CVV Number: ");
                        String CVV = sc.nextLine();
                        CreditCardPayment CC = new CreditCardPayment(CardNum, ExpDate, CVV);
                        return CC.processPayment(amount);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                }
                else if (choice == 2) {
                    sc.nextLine();
                    System.out.println("Enter your Email to your PayPal Account:");
                    String Email = sc.nextLine();
                    System.out.println("Enter the password: ");
                    String password = sc.nextLine();
                    PayPalPayment PP = new PayPalPayment(Email, password);
                    return PP.processPayment(amount);
                }
                else if (2<choice && choice<=numOfPaymentMethods) {
                    return true;
                }
                else if (choice == quit) {
                    // Handle the last option
                    break;
                }
                else {
                    System.out.println("Please enter a valid number.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Numbers only");
                sc.nextLine();
            }
        } while(choice != quit);

        sc.close();
        return false;
    }
}