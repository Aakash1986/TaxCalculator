package com.aakash.tax.calculator;

import java.math.BigDecimal;

public interface TaxCalculator {
    /**
     * ordinaryIncomeTax function is used to calculate Income tax which is 23% of total Income earned Monthly.
     * @param income Income Earned on Monthly Basis.
     * @return Returns Ordinary Income tax payable by User
     */
    BigDecimal ordinaryIncomeTax( BigDecimal income);

    /**
     * socialSecurityTax function is used to calculate social security tax which is 8.2% of Income and max of 25% of Income Exceeding 54650 kr
     * @param income Income Earned on Monthly Basis.
     * @return Returns Social Security tax payable by User
     */
    BigDecimal socialSecurityTax( BigDecimal income);
}
