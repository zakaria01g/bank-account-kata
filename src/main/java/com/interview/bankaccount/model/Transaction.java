package com.interview.bankaccount.model;

import java.util.Date;

public class Transaction {
    private final Date date;
    private final  double amount;

    private final TransactionType type;

    public Transaction(double amount, TransactionType type) {
        this.date = new Date();
        this.amount = amount;
        this.type = type;
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
}
