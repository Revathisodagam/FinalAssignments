package com.wipro.service;

import com.wipro.model.BankAccount;

public class AccountService {

    private BankAccount account;

    public AccountService(BankAccount account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public double getBalance() {
        return account.getBalance();
    }
}
