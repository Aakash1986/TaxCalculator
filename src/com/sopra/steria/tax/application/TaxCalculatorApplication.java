package com.sopra.steria.tax.application;

import com.sopra.steria.tax.calculator.TaxCalculator;
import com.sopra.steria.tax.calculator.impl.TaxCalculatorImpl;
import com.sopra.steria.tax.constant.TaxCalculatorConstants;
import com.sopra.steria.tax.data.DataValidator;

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
