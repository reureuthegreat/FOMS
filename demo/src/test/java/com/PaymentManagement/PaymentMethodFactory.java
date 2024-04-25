package com.PaymentManagement;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.Advice.Origin;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.Constructor;

public class PaymentMethodFactory {
    private static String classNameForInterceptor;

    public Object createPaymentMethod(String className, Object... params) {
        classNameForInterceptor = className;
        try {
            // Use Byte Buddy to create a new class implementing the interfaces
            Class<?> dynamicClass = new ByteBuddy()
                .subclass(Object.class) // Extend Object class
                .implement(iPaymentMethod.class, Payable.class) // Implement interfaces
                .method(ElementMatchers.named("getName"))
                .intercept(MethodCall.invoke(PaymentMethodFactory.class.getMethod("interceptGetName")))
                .method(ElementMatchers.named("processPayment"))
                .intercept(MethodCall.invoke(PaymentMethodFactory.class.getMethod("interceptProcessPayment")))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded();
            
            // Get constructor matching the parameter types
            Class<?>[] paramTypes = new Class[params.length];
            for (int i = 0; i < params.length; i++) {
                paramTypes[i] = params[i].getClass();
            }
            Constructor<?> constructor = dynamicClass.getConstructor(paramTypes);

            // Create new instance with constructor and params
            Object instance = constructor.newInstance(params);

            // Return instance
            return instance;

        } catch (NoSuchMethodException | InstantiationException |
                 IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Interceptor methods
    public static String interceptGetName() {
        try {
            return classNameForInterceptor;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean interceptProcessPayment() {
        try {
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
