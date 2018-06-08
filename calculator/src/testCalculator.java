import javax.swing.*;

public class testCalculator {
    public static void main(String args[]) {
        int number1 = Integer.parseInt(JOptionPane.showInputDialog("x"));
        int number2= Integer.parseInt(JOptionPane.showInputDialog("y"));;

        calculator calculator1 = new calculator(0,1);

        String decision = JOptionPane.showInputDialog("1: +, 2:- ; 3:* ; 4: /");
        calculator1.calculus(decision,number1,number2);

    }
}
