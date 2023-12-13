package com.interview.bankaccount.model;

import com.interview.bankaccount.exception.InsufficientFundsException;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
        transactions.add(new Transaction(amount, TransactionType.DEPOSIT));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (this.balance < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        this.balance -= amount;
        transactions.add(new Transaction(amount, TransactionType.WITHDRAWAL));
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
