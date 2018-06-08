package foodOrderSystem;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class order {
    private int orderID;
    private String accountId;
    private String foodId;
    private double amount;
    private int date_order;
    private int date_received; // T: buyer, F:seller
    private boolean status; //T F

    public order(String accid, String foodid, double money) {
        int i = 0;
        orderID = i++;
        accountId = accid;
        foodId = foodid;
        amount = money;
    }

    public void printOrder() {
        int i = 0;
            int ordId = i++;
            //Beccause delivery is a use and there is nothing to print receipt so I do not keep going to do the class beside of creating a constructor.

            JOptionPane.showMessageDialog(null, "Order is " + Integer.toString(orderID)+ "Account ID: " + accountId +"food you choose "+ foodId + "Amount " +Double.toString(amount));
            JOptionPane.showMessageDialog(null, "Thank you");

    }

    public void checkOrder() {
        JOptionPane.showMessageDialog(null, "Order no." + Integer.toString(orderID)+ "Account ID: " + accountId +"food you choose "+ foodId + "Amount " +Double.toString(amount));
    }


}

