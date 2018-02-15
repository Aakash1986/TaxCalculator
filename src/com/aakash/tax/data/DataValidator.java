package com.aakash.tax.data;

import java.math.BigDecimal;

public class DataValidator {
    public void validate(BigDecimal income){
        if(income.compareTo(BigDecimal.ZERO) < 0 ){
            throw new IllegalArgumentException("Only Positive Number allowed");
        }
    }
}
