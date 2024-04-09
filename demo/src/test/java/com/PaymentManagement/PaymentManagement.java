package com.PaymentManagement;
import java.util.ArrayList;

public class PaymentManagement {
    ArrayList <PaymentMethod> PaymentMethods;
    public PaymentManagement(){
        this.PaymentMethods = new ArrayList<>();
    }

    public void addPaymentMethod(String name){
        PaymentMethods.add(new PaymentMethod(name));
    }

    public void removePaymentMethod(String name){
        for(PaymentMethod paymentMethod : PaymentMethods){
            if(paymentMethod.getName().equals(name)){
                PaymentMethods.remove(paymentMethod);
            }
        }
    }

    public void displayPaymentMethods() {
        for(PaymentMethod paymentMethod : PaymentMethods){
            System.out.printf("%s ", paymentMethod.getName());
        }
    }
}
