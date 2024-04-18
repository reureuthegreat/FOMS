package com.PaymentManagement;

public class PayPalPayment implements iPaymentMethod, Payable {
    private String email;
    private String password;
    private String name;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
        name="Paypal";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean processPayment(double amount) {
        // Logic to process PayPal payment
        // Return true if payment is successful, otherwise false
        return true; // Placeholder
    }
}
