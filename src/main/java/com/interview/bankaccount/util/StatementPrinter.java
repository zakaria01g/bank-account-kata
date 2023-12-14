package com.interview.bankaccount.util;

import com.interview.bankaccount.model.Transaction;

import java.text.SimpleDateFormat;
import java.util.List;

public class StatementPrinter {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public void printStatement(List<Transaction> transactions) {
        System.out.printf("%-15s %-10s %-10s %-10s%n", "Date", "Type", "Amount", "Balance");

        for (Transaction transaction : transactions) {
            String formattedDate = DATE_FORMAT.format(transaction.getDate());
            System.out.printf("%-15s %-10s %-10.2f %-10.2f%n",
                    formattedDate,
                    transaction.getType(),
                    transaction.getAmount(),
                    transaction.getBalanceAfterTransaction());
        }
    }
}
