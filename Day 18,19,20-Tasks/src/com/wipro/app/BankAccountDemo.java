package com.wipro.app;

import com.wipro.model.BankAccount;
import com.wipro.service.AccountService;

public class BankAccountDemo {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        AccountService accountService = new AccountService(account);

        // Create multiple threads for depositing and withdrawing
        Thread depositThread1 = new Thread(new Depositor(accountService, 100));
        Thread withdrawThread1 = new Thread(new Withdrawer(accountService, 200));
        Thread depositThread2 = new Thread(new Depositor(accountService, 300));
        Thread withdrawThread2 = new Thread(new Withdrawer(accountService, 400));

        // Start the threads
        depositThread1.start();
        withdrawThread1.start();
        depositThread2.start();
        withdrawThread2.start();
    }

    static class Depositor implements Runnable {
        private AccountService accountService;
        private double amount;

        public Depositor(AccountService accountService, double amount) {
            this.accountService = accountService;
            this.amount = amount;
        }

        @Override
        public void run() {
            accountService.deposit(amount);
        }
    }

    static class Withdrawer implements Runnable {
        private AccountService accountService;
        private double amount;

        public Withdrawer(AccountService accountService, double amount) {
            this.accountService = accountService;
            this.amount = amount;
        }

        @Override
        public void run() {
            accountService.withdraw(amount);
        }
    }
}
