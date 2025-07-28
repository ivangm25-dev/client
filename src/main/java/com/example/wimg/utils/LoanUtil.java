package com.example.wimg.utils;

import com.example.wimg.entity.enums.CustomerType;

public class LoanUtil {

    /**
     * Get interestRate by customer type.
     * @param customerType
     * @return int.
     */
    public static int getInterestRate(CustomerType customerType){
        switch (customerType) {
            case VIP:
                return 5;
            default:
                return 10;
        }
    }

    /**
     * Calculate final payment by customer type.
     * @param amount
     * @param customerType
     * @return double.
     */
    public static double calculateFinalPayment(double amount, CustomerType customerType){
        switch (customerType) {
            case VIP:
                return amount * 1.05;
            default:
                return amount * 1.10;
        }
    }
}
