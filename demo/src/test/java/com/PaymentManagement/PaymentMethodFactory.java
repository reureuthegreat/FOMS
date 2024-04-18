package com.PaymentManagement;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PaymentMethodFactory {
    public iPaymentMethod createPaymentMethod(String className, Object... params) {
        try {
            Class<?> paymentMethodClass = Class.forName("com.PaymentManagement." + className);
            Constructor<?> constructor = paymentMethodClass.getConstructor(params.getClass());
            return (iPaymentMethod) constructor.newInstance(new Object[]{params});
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
