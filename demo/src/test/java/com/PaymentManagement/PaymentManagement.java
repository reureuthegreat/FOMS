package com.PaymentManagement;

import java.util.ArrayList;
import java.util.Iterator;

public class PaymentManagement {
    private static PaymentManagement instance = null;
    private ArrayList<iPaymentMethod> paymentMethods;
    private PaymentMethodFactory paymentMethodFactory;

    private PaymentManagement() {
        this.paymentMethods = new ArrayList<>();
        this.paymentMethodFactory = new PaymentMethodFactory();

        CreditCardPayment initialCreditCardPayment = new CreditCardPayment("4111111111111111", "12/25", "123");
        PayPalPayment initialPayPalPayment = new PayPalPayment("example@email.com", "password");

        paymentMethods.add(initialCreditCardPayment);
        paymentMethods.add(initialPayPalPayment);
    }

    public static PaymentManagement getInstance() {
        if (instance == null) {
            instance = new PaymentManagement();
        }
        return instance;
    }

    public void addPaymentMethod(String className, Object... params) {
        iPaymentMethod paymentMethod = (iPaymentMethod) paymentMethodFactory.createPaymentMethod(className, params);
        if (paymentMethod != null) {
            this.paymentMethods.add(paymentMethod);
        } else {
            System.out.println("Failed to create payment method");
        }
    }

    public void removePaymentMethod(String name) throws Exception {
        Iterator<iPaymentMethod> iterator = paymentMethods.iterator();
        while (iterator.hasNext()) {
            iPaymentMethod paymentMethod = iterator.next();
            if (paymentMethod.getName().equals(name)) {
                iterator.remove();
                return; // Exit the method after removing the first matching payment method
            }
        }
        throw new Exception("Payment method with name " + name + " not found");
    }

    public int displayPaymentMethods() {
        if (paymentMethods.isEmpty()) {
            System.out.println("No payment methods added.");
            return 0;
        }
        System.out.println("List of Payment Methods:");
        int numOfPaymentMethods = 0; // Counter variable to iterate numbers
        for (iPaymentMethod paymentMethod : paymentMethods) {
            System.out.printf("%d. %s\n", ++numOfPaymentMethods, paymentMethod.getName()); // Display payment methods with numbers
        }
        System.out.printf("%d. Quit", numOfPaymentMethods+1);
        return numOfPaymentMethods;
    }
}