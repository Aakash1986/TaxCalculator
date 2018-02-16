package com.sopra.steria.tax.calculator.impl;

import com.sopra.steria.tax.calculator.TaxCalculator;
import com.sopra.steria.tax.constant.TaxCalculatorConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculatorImpl implements TaxCalculator{

    @Override
    public BigDecimal ordinaryIncomeTax(BigDecimal income){
        //Tax on ordinary income for Person is 23%
        System.out.println("Calculated Ordinary Income Tax : " +income.multiply(BigDecimal.valueOf(TaxCalculatorConstants.ORDINARY_TAX)).setScale(2, RoundingMode.CEILING));
        return income.multiply(BigDecimal.valueOf(TaxCalculatorConstants.ORDINARY_TAX));
    }

    @Override
    public BigDecimal socialSecurityTax(BigDecimal income) {
        //Social Security Tax on wage 8.2% of the income
        BigDecimal sst = income.multiply(BigDecimal.valueOf(TaxCalculatorConstants.SS_WAGE_TAX));
        BigDecimal levelingIncome = income.subtract(new BigDecimal(TaxCalculatorConstants.SS_LOWER_LIMIT));
        BigDecimal sstThrushold = levelingIncome.multiply(BigDecimal.valueOf(TaxCalculatorConstants.SS_LEVELING_THRESHOLD));
        if (sst.compareTo(sstThrushold) < 0) {
            System.out.println("Calculate Social Security Tax : " + sst.setScale(2, RoundingMode.CEILING));
            return sst;
        } else {
            System.out.println("Calculate Social Security Tax : " + sstThrushold.setScale(2, RoundingMode.CEILING));
            return sstThrushold;
        }
    }
}
