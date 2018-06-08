import java.util.*;
import java.lang.*;
import javax.swing.JOptionPane;


public class test {

    public static void main(String[] args) {

        //1. ask how many number
        //2.Input number to array
        //3.validate numbers - re-enter number
        //4.check if any number have the same number

        //

        int maxNum;

        maxNum = Integer.parseInt(JOptionPane.showInputDialog("Please input number quantity:"));
        // User input words step, maxNum words is 20.
        // checking if the users choose more than 20 words,
        if (maxNum > 20 || maxNum < 20) {

            // Looping asking users to input quantity again until it is under 20
            while (maxNum > 20) {
                JOptionPane.showMessageDialog(null, "Sorry, it is too many, please choose under 20 words");
                maxNum = Integer.parseInt(JOptionPane.showInputDialog("Please input number quantity:"));
            }
            // Stage2 : stored user keywords
            int[] vocabulary = new int[maxNum]; // the amount in array is = maxNum
            boolean[] uniques = new boolean[maxNum];
            JOptionPane.showMessageDialog(null, "Please input " + maxNum + " numbers ");
            //For incremental vocabulary adding. Checking user vocabulary input
            for (int i = 0; i < maxNum; i++) {

                vocabulary[i] = Integer.parseInt(JOptionPane.showInputDialog("Input"));
                uniques[i] = true;
                for (int j = 0; j < maxNum; j++) {
                    if (vocabulary[i] == vocabulary[j] && i != j) {
                        uniques[i] = false;
                        //return unique number

                 }
                }
            }
            for (int i = 0; i < maxNum; i++) {
                if(uniques[i]) {      
                    System.out.println(vocabulary[i] + " is unique " );
                }
            }



        }
    }

}
