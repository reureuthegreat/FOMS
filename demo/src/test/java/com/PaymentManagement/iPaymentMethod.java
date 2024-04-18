package com.PaymentManagement;

public interface iPaymentMethod {
    String getName();
    boolean processPayment(double amount);
}
