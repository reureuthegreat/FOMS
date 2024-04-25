package com.PaymentManagement;

/**
 * Represents a payable interface for processing payments.
 */
public interface Payable {

    /**
     * Processes a payment with the specified amount.
     *
     * @param amount The amount to be paid.
     * @return true if the payment is processed successfully, false otherwise.
     */
    boolean processPayment(double amount);
} 