package com.PaymentManagement;

import java.util.Calendar;

public class CreditCardPayment implements iPaymentMethod, Payable {
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String name;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        if (isValidCreditCardNumber(cardNumber) && isValidExpiryDate(expiryDate) && isValidCVV(cvv)) {
            this.cardNumber = cardNumber;
            this.expiryDate = expiryDate;
            this.cvv = cvv;
            this.name = "CreditCard";
        } else {
            throw new IllegalArgumentException("Invalid credit card details");
        }
    }

    private boolean isValidCreditCardNumber(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            
            sum += n;
            alternate = !alternate;
        }
        
        return (sum % 10 == 0);
    }

    private boolean isValidExpiryDate(String expiryDate) {
    // Assuming expiryDate format is MM/YY
    if (expiryDate.matches("\\d{2}/\\d{2}")) {
        String[] parts = expiryDate.split("/");
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);
        
        // Check if the expiry date is in the future
        // Assuming current date format is YY (last two digits of the year)
        int currentYear = Integer.parseInt(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)).substring(2));
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1; // Calendar months are 0-based
        
        if (year > currentYear || (year == currentYear && month >= currentMonth)) {
            return true;
        }
    }
        return false;
    }

    private boolean isValidCVV(String cvv) {
        // Assuming CVV is a 3 or 4-digit number
        return cvv.matches("\\d{3,4}");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean processPayment(double amount) {
        return true; // Placeholder
    }
}
