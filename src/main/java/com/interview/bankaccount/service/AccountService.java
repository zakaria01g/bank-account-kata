package com.interview.bankaccount.service;

import com.interview.bankaccount.model.Account;
import com.interview.bankaccount.model.Transaction;
import com.interview.bankaccount.util.StatementPrinter;

import java.util.List;

public class AccountService {
    private Account account;
    private final StatementPrinter statementPrinter = new StatementPrinter();

    public AccountService(Account account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public void printStatement() {
        List<Transaction> transactions = account.getTransactions();
        statementPrinter.printStatement(transactions);
    }
}
