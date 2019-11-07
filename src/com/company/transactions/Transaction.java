package com.company.transactions;

import com.company.users.User;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private User from;
    private User to;
    private double amount;

    public Transaction(User from, User to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;

    }

    private boolean isValid() {
        return from.getBalance() >= amount;


    }

    public List<User> execute() {
        //sukuriam nauja sarasa tuscia
        List<User> transactedUsers = new ArrayList<>();
        //patikrinam ar galime daryti transakcija ar uztenka pinigu
        if (isValid()) {
            //padarom pavedima
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
        }else {
            System.out.println("ERROR: Transakcija yra nevalidi");
        }
        transactedUsers.add(from);
        transactedUsers.add(to);
        return transactedUsers;
    }
}
