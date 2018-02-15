package com.aakash.tax;

import java.math.BigDecimal;

public interface TaxCalculator {
    BigDecimal ordinaryIncomeTax( BigDecimal income);
    BigDecimal socialSecurityTax( BigDecimal income);
}
