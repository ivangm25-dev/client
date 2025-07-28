package com.example.wimg.utils;

import com.example.wimg.entity.enums.CustomerType;

public class CustomerTypeUtil {

    /**
     * Verify if the client has discount.
     * @param customerType
     * @return True or False.
     */
    public static boolean hasDiscount(CustomerType customerType){
        switch (customerType) {
            case VIP:
                return true;
            default:
                return false;
        }
    }
}
