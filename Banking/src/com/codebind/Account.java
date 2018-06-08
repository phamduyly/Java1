package com.codebind;

import javax.swing.plaf.PanelUI;

public class Account {
    //Todo: Log in - withdraw/transfer

    private String name;
    private double balance;
    private String accID;
    private String accPass;


    public Account(String accountID, String accountPass, String accountName, double amount) {
        accID = accountID;
        accPass = accountPass;
        name = accountName;
        balance = amount;
    }

    //Log in
    public boolean login(String logAcc, String logPass) {
        if (logAcc.equals(accID) && logPass.equals(accPass)) {
            System.out.println("Log in");
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getID() {
        return accID;
    }

    public String getName() {
        return name;
    }

    public void deposit(double amount) {
        balance += amount;

    }

    public boolean withdraw(double amount) {
        if (amount < balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(Account other, double amount) {
        if (amount < balance) {
            balance -= amount;

            other.balance = other.getBalance() + amount;
            return true;
        }
        return false;
    }

    public boolean payment (double amount) {
        if (amount < balance) {
            balance -=amount;

            return true;
        }
        return false;
    }
}


