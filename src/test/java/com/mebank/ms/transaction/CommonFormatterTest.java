package com.mebank.ms.transaction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CommonFormatterTest {

    @Test
    void testGetLocalDateTimeFromString(){
        Assertions.assertSame(LocalDateTime.class, CommonFormatter.getLocalDateTimeFromString("20/10/2018 19:45:00").getClass());
    }

    @Test
    void testStringToLongCurrencyConversion(){
        ;
        Assertions.assertEquals(2523l, CommonFormatter.convertDollarToCent("25.23"));
    }

    @Test
    void testLongToDollarDisplayConversion(){
        Assertions.assertEquals("$25.23", CommonFormatter.convertCentToDollar(2523));
    }

}
