package com.PaymentManagement;
import java.util.ArrayList;
import java.util.Iterator;

public class PaymentManagement {
    private ArrayList<iPaymentMethod> paymentMethods;
    private PaymentMethodFactory paymentMethodFactory;

    public PaymentManagement() {
        this.paymentMethods = new ArrayList<>();
        this.paymentMethodFactory = new PaymentMethodFactory();
    }

    public void addPaymentMethod(String className, Object... params) {
        iPaymentMethod paymentMethod = (iPaymentMethod)paymentMethodFactory.createPaymentMethod(className, params);
        if (paymentMethod != null) {
            paymentMethods.add(paymentMethod);
        } else {
            System.out.println("Failed to create payment method");
        }
    }

    public void removePaymentMethod(String name) {
        Iterator<iPaymentMethod> iterator = paymentMethods.iterator();
        while (iterator.hasNext()) {
            iPaymentMethod paymentMethod = iterator.next();
            if (paymentMethod.getName().equals(name)) {
                iterator.remove();
                break; // Exit the loop after removing the first matching payment method
            }
        }
    }
    

    public void displayPaymentMethods() {
        for (iPaymentMethod paymentMethod : paymentMethods) {
            System.out.printf("%s ", paymentMethod.getName());
        }
    }
}
