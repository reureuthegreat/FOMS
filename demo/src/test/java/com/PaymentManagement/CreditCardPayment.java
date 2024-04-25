package com.PaymentManagement;

import java.util.Calendar;

/**
 * Represents a Credit Card payment method.
 */
public class CreditCardPayment implements iPaymentMethod, Payable {
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String name;

    /**
     * Constructs a CreditCardPayment object with the specified card details.
     *
     * @param cardNumber The credit card number.
     * @param expiryDate The expiry date of the credit card in the format MM/YY.
     * @param cvv        The CVV number of the credit card.
     * @throws IllegalArgumentException if the credit card details are invalid.
     */
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

    /**
     * Validates the credit card number using the Luhn algorithm.
     *
     * @param cardNumber The credit card number to validate.
     * @return true if the credit card number is valid, false otherwise.
     */
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

    /**
     * Validates the expiry date of the credit card.
     *
     * @param expiryDate The expiry date to validate in the format MM/YY.
     * @return true if the expiry date is valid and in the future, false otherwise.
     */
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

    /**
     * Validates the CVV number of the credit card.
     *
     * @param cvv The CVV number to validate.
     * @return true if the CVV number is valid, false otherwise.
     */
    private boolean isValidCVV(String cvv) {
        // Assuming CVV is a 3 or 4-digit number
        return cvv.matches("\\d{3,4}");
    }

    /**
     * Gets the name of the payment method.
     *
     * @return The name of the payment method.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Processes a payment using the credit card.
     *
     * @param amount The amount to be paid.
     * @return true if the payment is processed successfully, false otherwise.
     */
    @Override
    public boolean processPayment(double amount) {
        return true; // Placeholder
    }
}
