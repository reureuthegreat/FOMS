package com.PaymentManagement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PaymentMethodFactory {
    
    public Object createPaymentMethod(String className, Object... params) {
        try {
            Class<?> paymentMethodClass = Class.forName("com.PaymentManagement." + className);
            
            // Get all interfaces implemented by the class
            Class<?>[] interfaces = paymentMethodClass.getInterfaces();
            
            // Check if the class implements both iPaymentMethod and Payable
            boolean implementsIPayment = false;
            boolean implementsPayable = false;
            
            for (Class<?> intf : interfaces) {
                if (intf.equals(iPaymentMethod.class)) {
                    implementsIPayment = true;
                }
                if (intf.equals(Payable.class)) {
                    implementsPayable = true;
                }
            }
            
            if (implementsIPayment && implementsPayable) {
                Constructor<?> constructor = paymentMethodClass.getConstructor(params.getClass());
                return constructor.newInstance(new Object[]{params});
            } else {
                throw new IllegalArgumentException(className + " does not implement both iPaymentMethod and Payable interfaces.");
            }
            
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
