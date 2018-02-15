package com.aakash.tax.application;

import com.aakash.tax.TaxCalculator;
import com.aakash.tax.calculator.impl.TaxCalculatorImpl;
import com.aakash.tax.constant.TaxCalculatorConstants;
import com.aakash.tax.data.DataValidator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class TaxCalculatorApplication {

    public static void main(String []args){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Monthly Income :");
            BigDecimal income = sc.nextBigDecimal();
            DataValidator dataValidator = new DataValidator();
            dataValidator.validate(income);
            TaxCalculator taxCalc = new TaxCalculatorImpl();
            BigDecimal taxPaid;
            if (income.compareTo(new BigDecimal(TaxCalculatorConstants.SS_LOWER_LIMIT)) > 0) {
                taxPaid = taxCalc.ordinaryIncomeTax(income).add(taxCalc.socialSecurityTax(income));
            } else
                taxPaid = taxCalc.ordinaryIncomeTax(income);

            System.out.println("Total Tax to be Payed(Ordinary+SST) : " + taxPaid.setScale(2, RoundingMode.CEILING));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
