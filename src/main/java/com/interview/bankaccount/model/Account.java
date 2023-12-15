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

    /**
     * Deposits a specified amount into the account.
     *
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if the amount is less than or equal to zero
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        double newBalance = this.balance + amount;
        transactions.add(new Transaction(amount, TransactionType.DEPOSIT, newBalance));
        this.balance = newBalance;
    }

    /**
     * Withdraws a specified amount from the account.
     *
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if the amount is less than or equal to zero
     * @throws InsufficientFundsException if there are insufficient funds in the account
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (this.balance < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        double newBalance = this.balance - amount;
        transactions.add(new Transaction(amount, TransactionType.WITHDRAWAL, newBalance));
        this.balance = newBalance;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
