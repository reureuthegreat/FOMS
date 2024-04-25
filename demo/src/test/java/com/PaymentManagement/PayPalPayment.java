package com.PaymentManagement;

/**
 * Represents a PayPal payment method that implements the iPaymentMethod and Payable interfaces.
 */
public class PayPalPayment implements iPaymentMethod, Payable {
    private String email;
    private String password;
    private String name;

    /**
     * Constructs a new PayPalPayment instance with the specified email and password.
     *
     * @param email    The email associated with the PayPal account.
     * @param password The password for the PayPal account.
     */
    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
        name="Paypal";
    }

    /**
     * Gets the name of the payment method.
     *
     * @return The name of the payment method (Paypal).
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Processes a payment using PayPal.
     *
     * @param amount The amount to be paid.
     * @return true if the payment is successful, otherwise false (placeholder implementation).
     */
    @Override
    public boolean processPayment(double amount) {
        // Logic to process PayPal payment
        // Return true if payment is successful, otherwise false
        return true; // Placeholder
    }
}
