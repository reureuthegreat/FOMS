package com.Branch;

import com.PaymentManagement.*;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PaymentApp {
    public PaymentApp(){}
    int choice;
    Scanner sc= new Scanner(System.in);
    PaymentManagement PM = PaymentManagement.getInstance();
    public void paymentapp(double amount){
        do {
            System.out.println("=================Choose your Payment Type=================");
            PM.displayPaymentMethods();
            System.out.println("======================================================================\n");
            System.out.println("Please enter number of your selection: ");
            try {
                choice = sc.nextInt();
                switch(choice){
                    case 1:
                        sc.nextLine();
                        System.out.println("Enter your credit Card Number: ");
                        String CardNum = sc.nextLine();
                        System.out.println("Enter the Expiry Date: ");
                        String ExpDate = sc.nextLine();
                        System.out.println("Enter your Card CVV Number: ");
                        String CVV = sc.nextLine();
                        CreditCardPayment CC = new CreditCardPayment(CardNum,ExpDate,CVV);
                        CC.processPayment(amount);
                        return;
                    case 2:
                        sc.nextLine();
                        System.out.println("Enter your Email to your Paypal Account:");
                        String Email = sc.nextLine();
                        System.out.println("Enter the password: ");
                        String password = sc.nextLine();
                        PayPalPayment PP = new PayPalPayment(Email,password);
                        PP.processPayment(amount);
                        return;
                    case 3:
                        break;
                    default:
                        System.out.println("Please enter 1,2 or 3.");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Numbers only");
                sc.nextLine();
            }
        }while(choice!=3);
    }
}