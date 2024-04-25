package com.PaymentManagement;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manages the payment methods available in the system.
 */
public class PaymentManagement {
    private static PaymentManagement instance = null;
    private ArrayList<iPaymentMethod> paymentMethods;
    private PaymentMethodFactory paymentMethodFactory;

    /**
     * Constructs a PaymentManagement instance.
     */
    private PaymentManagement() {
        this.paymentMethods = new ArrayList<>();
        this.paymentMethodFactory = new PaymentMethodFactory();

        CreditCardPayment initialCreditCardPayment = new CreditCardPayment("4111111111111111", "12/25", "123");
        PayPalPayment initialPayPalPayment = new PayPalPayment("example@email.com", "password");

        paymentMethods.add(initialCreditCardPayment);
        paymentMethods.add(initialPayPalPayment);
    }

    /**
     * Returns the singleton instance of PaymentManagement.
     *
     * @return The singleton instance of PaymentManagement.
     */
    public static PaymentManagement getInstance() {
        if (instance == null) {
            instance = new PaymentManagement();
        }
        return instance;
    }


    /**
     * Adds a new payment method to the system.
     *
     * @param className The class name of the payment method to be added.
     * @param params    The parameters required to create the payment method.
     */
    public void addPaymentMethod(String className, Object... params) {
        iPaymentMethod paymentMethod = (iPaymentMethod) paymentMethodFactory.createPaymentMethod(className, params);
        if (paymentMethod != null) {
            this.paymentMethods.add(paymentMethod);
        } else {
            System.out.println("Failed to create payment method");
        }
    }

    /**
     * Removes a payment method from the system.
     *
     * @param name The name of the payment method to be removed.
     * @throws Exception If the payment method with the specified name is not found.
     */
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

    /**
     * Displays the list of payment methods available in the system.
     *
     * @return The number of payment methods displayed.
     */
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