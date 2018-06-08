import javax.swing.*;

public class Account {
    //Todo: Log in - withdraw/transfer

    private String name;
    private double balance;
    private String accID;
    private String accPass;
// Private and public. -- good OOB is to hide the instance variable. -->that is way there is public - return

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


