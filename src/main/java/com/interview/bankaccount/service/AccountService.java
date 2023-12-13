package com.interview.bankaccount.service;

import com.interview.bankaccount.model.Account;

public class AccountService {
    private Account account;

    public AccountService(Account account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }
}
