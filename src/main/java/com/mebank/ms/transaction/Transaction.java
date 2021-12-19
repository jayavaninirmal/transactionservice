package com.mebank.ms.transaction;

import java.time.LocalDateTime;

public class Transaction {

    private String transactionID;
    private String fromAccountID;
    private String toAccountID;
    private LocalDateTime createdAt;
    private long amountInCents;
    private TransactionTypes transactionType;
    private String relatedPayment;

    public Transaction(String... transactionData) {
        this.transactionID = transactionData[0].trim();
        this.fromAccountID = transactionData[1].trim();
        this.toAccountID = transactionData[2].trim();
        this.createdAt = CommonFormatter.getLocalDateTimeFromString(transactionData[3].trim());
        this.amountInCents = CommonFormatter.convertDollarToCent(transactionData[4].trim());
        this.transactionType = TransactionTypes.valueOf(transactionData[5].trim());
        if(this.transactionType.equals(TransactionTypes.REVERSAL)) {
            this.relatedPayment = transactionData[6].trim();
        }
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getFromAccountID() {
        return fromAccountID;
    }

    public String getToAccountID() {
        return toAccountID;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public long getAmountInCents() {
        return amountInCents;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public String getRelatedPayment() {
        return relatedPayment;
    }
}
