package foodOrderSystem;
import javax.swing.*;
import java.lang.*;


public class account {

    private String accountId;
    private String accPass;
    private String name;
    private String gender;
    private int DOB;
    private String address;
    private String type; // T: buyer, F:seller
    private int orderId;
    private int[] foodsId;
    private double balance;
    private food food;


    public account (String accID, String name1, String accountPass, String sex, int dateOb, String address1, String condition, double money) {
        accountId = accID;
        accPass = accountPass;
        name = name1;
        gender = sex;
        DOB = dateOb;
        address = address1;
        type = condition;
        balance = money;
    }

    public boolean login(String logAcc, String logPass) {
        if (logAcc.equals(accountId) && logPass.equals(accPass)) {
            System.out.println("Log in");
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getID() {
        return accountId;
    }

    public String getPass() {
        return accPass;
    }
    public String getName() {
        return name;
    }

    public double getAmount() {
        double amount = Double.parseDouble(JOptionPane.showInputDialog("Please Input amount"));
        return amount;
    }

    public void deposit(double amount) { //Setters or mutators. -- react to external stimulus, which will alter the state of the orgiin class, account in this case
        balance += amount;
    }

    public boolean withdraw(double amount) { // also mutators -- anything that change the state
        if (amount < balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(account other, double amount) {
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

    public void changefoodInfor() {
        int choice = Integer.parseInt(JOptionPane.showInputDialog("choose your option"));
        while (choice != 9) {
            if (choice == 0) {
                String name1 = JOptionPane.showInputDialog("new");
                food.changeName(name1);
            } else if ( choice == 1) {
                String name1 = JOptionPane.showInputDialog("new");
                food.changeDescription(name1);
            } else if (choice == 3) {
                double price1 = Double.parseDouble(JOptionPane.showInputDialog("new"));
                food.changePrice(price1);
            }
        }
    }

/* Todo: later since in the mainn() already have this function
    public boolean login(String logAcc, String logPass) {
        if (logAcc.equals(accID) && logPass.equals(accPass)) {
            System.out.println("Log in");
            return true;
        }
        return false;
    }*/
/*
    public boolean payment (double amount) { // minus money
        if (amount < balance) {
            balance -=amount;

            return true;
        }
        return false;
    }*/


}
