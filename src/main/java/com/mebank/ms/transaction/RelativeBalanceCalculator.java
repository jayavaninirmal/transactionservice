package com.mebank.ms.transaction;

import java.time.LocalDateTime;
import java.util.List;

public class RelativeBalanceCalculator {
    private List<Transaction> transactionList;

    public RelativeBalanceCalculator(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }


    public String calculateRelativeBalanceFor(String accountID, LocalDateTime fromDateTime, LocalDateTime toDateTime){
        long relativeBalance = 0;
        long reversalBalance = 0;
        int transactionCounter = 0;
        for (Transaction transaction : transactionList){
            if(transaction.getCreatedAt().isAfter(fromDateTime) && transaction.getCreatedAt().isBefore(toDateTime) && transaction.getTransactionType().equals(TransactionTypes.PAYMENT)){
                if(transaction.getFromAccountID().equals(accountID)){
                    relativeBalance -= transaction.getAmountInCents();
                    transactionCounter++;
                }else if(transaction.getToAccountID().equals(accountID)){
                    relativeBalance += transaction.getAmountInCents();
                    transactionCounter++;
                }
            }
            else if(transaction.getTransactionType().equals(TransactionTypes.REVERSAL)){
                if(transaction.getFromAccountID().equals(accountID)){
                    reversalBalance += transaction.getAmountInCents();
                    transactionCounter--;
                }else if(transaction.getToAccountID().equals(accountID)){
                    reversalBalance -= transaction.getAmountInCents();
                    transactionCounter--;
                }
            }
        }
        relativeBalance += reversalBalance;
        return "Relative balance for this period is: " + CommonFormatter.convertCentToDollar(relativeBalance) + "\n Number of transactions included is: " + transactionCounter;
    }
}
