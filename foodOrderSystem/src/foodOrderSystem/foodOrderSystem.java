package foodOrderSystem;

import javax.swing.*;
import java.lang.*;
import java.util.Arrays;

public class foodOrderSystem {
    private int accountId;
    private String[] foodname;//using for order funcion
    private String foodid;
    private int deliveryid;
    private int orderid;
    private double money;
    private order order;
    private delivery delivery;
    private account[] accountArray;
    private food[] foodArray;
    private String foodidArray;
    private food food;

    int y;
    int maxNum = 20;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        foodOrderSystem testObj = new foodOrderSystem();

    }

    public foodOrderSystem() {
        // a view here
        this.signUpIn();
        //this.orderFood();
        //Place for order food ?

        accountArray[y].changefoodInfor(); // if account is seelter
    }

    public void signUpIn() {

        this.accountArray = new account[maxNum];
        accountArray[0] = new account("1", "Ly", "test", "Male",
                8797, "test address VIC", "buyer", 1000);
        accountArray[1] = new account("2", "L1y", "te1st", "Male",
                8797, "test address VIC", "buyer", 1000);
        //why we need this here.
        this.foodArray = new food[10];
        foodArray[0] = new food("1", "Soup", 10, "testing description for this");
        foodArray[1] = new food("2", "Soup1", 12, "testing description for this");
        foodArray[2] = new food("3", "Soup2", 14, "testing description for this");
        foodArray[3] = new food("4", "Soup4", 12, "testing description for this");
        foodArray[4] = new food("5", "Soup3", 11, "testing description for this");

        int choice1 = Integer.parseInt(JOptionPane.showInputDialog("1. if you have account - 2. if you want register"));
        if (choice1 == 2) {

            for (int i = 0; i < maxNum; i++) {
                String id = Integer.toString(i);
                String name1 = JOptionPane.showInputDialog("Input your name");
                String accountPass = JOptionPane.showInputDialog("Input your pass");
                String sex1 = JOptionPane.showInputDialog("Input your name");

                int dateOb = Integer.parseInt(JOptionPane.showInputDialog("Input your dob"));
                String address1 = JOptionPane.showInputDialog("Input your address");
                String condition = JOptionPane.showInputDialog("seller or buyer");
                double money = Double.parseDouble(JOptionPane.showInputDialog("Input your deposit"));

                // Creating account
                this.accountArray[i] = new account(id, accountPass, name1, sex1, dateOb, address1, condition, money);
                JOptionPane.showMessageDialog(null, "Done" + "You information is " + " " + accountArray[i].getName() + " " + accountArray[i].getID() + " " + accountArray[i].getBalance());

            }
        } else {
            String id = JOptionPane.showInputDialog("id");
            String pass = JOptionPane.showInputDialog("Input your password");

            for (int x = 0; x < maxNum; x++) {
                y = x;
                while (id.equals(accountArray[x].getID()) && pass.contains(accountArray[x].getPass())) { // equals when I is int
                    JOptionPane.showMessageDialog(null, "Loged In");
                    this.orderFood();
                    // get food constructor out by Joption Pane - have a button for print order and print delivery
                }
            }
        }
    }

    public String addFood() {
            String foodchosen = JOptionPane.showInputDialog("choose food that you want " + "0." +foodArray[0].getName() +
                    "1." + foodArray[1].getName() + "2." +foodArray[2].getName());
            foodidArray = foodchosen;

        JOptionPane.showMessageDialog(null, "foods you chose " + foodArray);
        return foodidArray;
    }


    public void orderFood() {
        //passing information for order andd delivery

        //Step1: add each food
        //Step2 good than add
        //Step2: match with food name// number; Else - ask to choose again;
        //Step3: add to order object - print Done

        this.addFood();
        String ac1Id = accountArray[y].getID();
        String fID = foodidArray;
        double amount = 100;

        order = new order(ac1Id, fID, amount);
        order.printOrder();
    }
}
/*        int maxChoice = Integer.parseInt(JOptionPane.showInputDialog("num of food"));
        JOptionPane.showMessageDialog(null, "Please input" + maxChoice + " words that you want to talk about: ");
        this.accountArray[y].getBalance();

        String accountid = this.accountArray[y].getID();
        int i = 0;
        foodid = JOptionPane.showInputDialog("input");*/




        //For incremental vocabulary adding. Checking user vocabulary input
/*        for (int i = 0; i < maxChoice; i++) {
            foodname[i] = JOptionPane.showInputDialog("Input");
            //Step2: match with food name// number; Else - ask to choose again;
            if (!foodname[i].equals("?")) {
                JOptionPane.showMessageDialog(null, "I remembered it!");
                //if user have ? than delete the ? keywords
            } else {
                JOptionPane.showMessageDialog(null,
                        "Sorry, there is no food");
                //Deleted the words that is not appropriate
                foodname[i] = null;
            }

            for (int x = 0; x < 100; x++) {
                while (foodname[i].contains(foodArray[x].getName())) {
                    int k = x;
                    foodid = foodArray[k].getFoodId();

                }
            }
        }*/



