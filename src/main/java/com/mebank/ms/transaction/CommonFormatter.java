package com.mebank.ms.transaction;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Locale;

public class CommonFormatter {

    public static LocalDateTime getLocalDateTimeFromString(String input) {
        return LocalDateTime.parse(input, GlobalConstants.formatter);
    }

    public static long convertDollarToCent(String inputNumber){
        //Trying to retain as much precision as possible. BigDecimal will be a better option if more precision is needed, but for 2 digit fractional values, meh.
        double interimVal = Double.parseDouble(inputNumber);
        interimVal *= 100;
        return (long) interimVal;
    }

    public static String convertCentToDollar(long centValue){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(centValue / 100.0);
    }

}
