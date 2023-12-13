package com.interview.bankaccount.model;

import java.util.Date;

public class Transaction {
    private final Date date;
    private final double amount;
    private final TransactionType type;
    private final double balanceAfterTransaction;

    public Transaction(double amount, TransactionType type, double balanceAfterTransaction) {
        this.date = new Date();
        this.amount = amount;
        this.type = type;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }
}
