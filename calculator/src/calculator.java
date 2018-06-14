import javax.swing.*;

public class calculator {
    private double result;
    private double numberX;
    private double numberY;
    private String choice;

    public calculator (int num1, int num2) {
        numberX = num1;
        numberY = num2;


    }


    public boolean calculus(String decision, double number, double number2) {

        if (decision.equals("plus")) {
            result = number + number2;
            System.out.println(result);
            return true;

        } else if (decision.contains("minus")) {
            result = number - number2;
            System.out.println(result);
            return true;

        } else if (decision.contains("times")) {
            result = number * number2;
            System.out.println(result);
            return true;

        } else if (decision.contains("divide")) {
            result = number / number2;
            System.out.println(result);
            return true;
        }
        return false;
    }
}

