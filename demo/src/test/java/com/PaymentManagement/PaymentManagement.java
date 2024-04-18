package com.PaymentManagement;
import java.util.ArrayList;

public class PaymentManagement {
    private ArrayList<iPaymentMethod> paymentMethods;
    private PaymentMethodFactory paymentMethodFactory;

    public PaymentManagement() {
        this.paymentMethods = new ArrayList<>();
        this.paymentMethodFactory = new PaymentMethodFactory();
    }

    public void addPaymentMethod(String className, Object... params) {
        iPaymentMethod paymentMethod = paymentMethodFactory.createPaymentMethod(className, params);
        if (paymentMethod != null) {
            paymentMethods.add(paymentMethod);
        } else {
            System.out.println("Failed to create payment method");
        }
    }

    public void removePaymentMethod(String name) {
        paymentMethods.removeIf(paymentMethod -> paymentMethod.getName().equals(name));
    }

    public void displayPaymentMethods() {
        for (iPaymentMethod paymentMethod : paymentMethods) {
            System.out.printf("%s ", paymentMethod.getName());
        }
    }
}
