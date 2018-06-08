package foodOrderSystem;

import javax.swing.*;
import java.awt.*;

public class food {
    private String foodId;
    private String name;
    private int type;
    private double price;
    private int date_listed; // listed food date
    private int date_end; // T: buyer, F:seller
    private String description;
    private int accountId;
    private int ordId;
    private int accid;
    private String foodid;
    private double money;

    public food(String foodid, String foodname, double foodprice, String description1){
        foodId = foodid;
        name = foodname;
        price = foodprice;
        description = description1;
    }

/*
    public void order() {
        //passing information for order andd delivery

        //order order1 = new order(ordId, accid, foodid, money); // passing value into this;
        //order1.printOrder();
        //Beccause delivery is a use and there is nothing to print receipt so I do not keep going to do the class beside of creating a constructor.
        JOptionPane.showMessageDialog(null,"Thank you");

    }
*/

    //Does order be in food class or order be in main class

    public String getName(){
        return name;
    }

    public String getFoodId(){
        return foodId;
    }

    public double getFoodPrice(){
        return price;
    }

    public String getDescription(){
        return description;
    }

    public String changeName(String name1){

        name1 = name;
        return name;
    }

    public double changePrice(double price1){

        price1 = price;
        return price1;

        //What does reurn new do
    }

    public String changeDescription(String des1){
        des1 = JOptionPane.showInputDialog("new");
        des1 = description;
        return description;
    }



}
