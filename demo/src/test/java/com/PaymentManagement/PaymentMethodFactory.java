package com.PaymentManagement;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.implementation.bind.annotation.Origin;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class PaymentMethodFactory {
    
    public Object createPaymentMethod(String className, Object... params) {
        try {
            // Use Byte Buddy to create a new class implementing the interfaces
            Class<?> dynamicClass = new ByteBuddy()
                .subclass(Object.class) // Extend Object class
                .implement(iPaymentMethod.class, Payable.class) // Implement interfaces
                .method(ElementMatchers.named("getName"))
                .intercept(MethodDelegation.to(MyInterceptor.class)) // Implement getName method
                .method(ElementMatchers.named("processPayment"))
                .intercept(MethodDelegation.to(MyInterceptor.class)) // Implement processPayment method
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
    
    // Interceptor class to provide method implementations
    public static class MyInterceptor {

        @RuntimeType
        public static Object interceptGetName(@Origin Method method, @AllArguments Object[] args) {
            try {
                // Get the actual instance and cast it to iPaymentMethod
                iPaymentMethod paymentMethod = (iPaymentMethod) args[0];
                return paymentMethod.getName();
            } catch (ClassCastException e) {
                e.printStackTrace();
                return null;
            }
        }
    
        @RuntimeType
        public static boolean interceptProcessPayment(@Origin Method method, @AllArguments Object[] args, @AllArguments Object amount) {
            try {
                // Get the actual instance and cast it to Payable
                Payable paymentMethod = (Payable) args[0];
                return paymentMethod.processPayment((double) amount);
            } catch (ClassCastException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
        
    }


    
