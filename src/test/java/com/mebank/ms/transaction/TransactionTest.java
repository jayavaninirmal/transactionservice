package com.mebank.ms.transaction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    void testTransactionConstructor(){
        Assertions.assertSame(Transaction.class, new Transaction("TX10003", "ACC998877", "ACC778899", "20/10/2018 18:00:00", "5.00", "PAYMENT").getClass());
    }

    @Test
    void testTransactionConstructorWithNullRelatedTransaction(){
        Assertions.assertNull(new Transaction("TX10003", "ACC998877", "ACC778899", "20/10/2018 18:00:00", "5.00", "PAYMENT").getRelatedPayment());
    }

    @Test
    void testTransactionConstructorWithARelatedTransaction(){
        Assertions.assertSame(Transaction.class, new Transaction("TX10003", "ACC998877", "ACC778899", "20/10/2018 18:00:00", "5.00", "REVERSAL", "TX10002").getClass());
    }

    @Test
    void testTransactionConstructorValueOfWithARelatedTransaction(){
        Assertions.assertNotNull(new Transaction("TX10003", "ACC998877", "ACC778899", "20/10/2018 18:00:00", "5.00", "REVERSAL", "TX10002").getRelatedPayment());
    }

    @Test
    void testTransactionConstructorValueWithoutRelatedValueForReversal(){
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {new Transaction("TX10003", "ACC998877", "ACC778899", "20/10/2018 18:00:00", "5.00", "REVERSAL").getClass();});
    }

}
