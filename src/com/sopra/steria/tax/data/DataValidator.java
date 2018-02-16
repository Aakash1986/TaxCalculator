package com.sopra.steria.tax.data;

import java.math.BigDecimal;

public class DataValidator {

    /**
     * Validate method will validate input provided by users.
     * @param income Income Earned on Monthly Basis.
     */
    public void validate(BigDecimal income){
        if(income.compareTo(BigDecimal.ZERO) < 0 ){
            throw new IllegalArgumentException("Only Positive Number allowed");
        }
    }
}
