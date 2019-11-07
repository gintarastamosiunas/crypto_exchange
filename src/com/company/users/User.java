package com.company.users;

import java.util.Random;

public class User {
    private String name;
    private double balance;
    private String accountNumber;


    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        Random random = new Random();
        this.accountNumber = "LT" + (random.nextInt(99999 - 10000) + 10000);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}

