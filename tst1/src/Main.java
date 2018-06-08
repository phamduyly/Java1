import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        int x = Integer.parseInt(JOptionPane.showInputDialog("x"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("y"));
        System.out.println(divX(x));
        System.out.println(divY(y));

    }


    public static int divX(int t) {
        int divX = 0;
        if (t > 100) {
            divX = 100;
        } else if (t > 10 && t < 100) {
            divX = 10;
        } else if (t < 10) {
            divX = 1;
        }

        return divX;
    }

    public static int divY(int t) {
        int divY = 0;
        if (t > 100) {
            divY = 100;
        } else if (t > 10 && t < 100) {
            divY = 10;
        } else if (t < 10) {
            divY = 1;
        }

        return divY;
    }

    int[] test= new int[3];
    test.ch
}