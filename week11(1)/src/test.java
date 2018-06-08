import javax.swing.*;

public class test {

    public static void main(String[] args) {
        int t = Integer.parseInt(JOptionPane.showInputDialog("input number"));
        JOptionPane.showMessageDialog(null,getSignAndParity(t));
    }

    public static String getSignAndParity(int t) {
        String y = checkSign(t);
        String q = checkOdd(t);

        String e = y + " " +q;
        return e;
    }

    static String x;
    private static String checkSign(int t) {
        if (t < 0) {
            x = "Negative";
        } else if (t > 0) {
            x = "positive";
        }

        return x;

    }

    static String p;
    private static String checkOdd(int t) {
        if ((t%2) == 0) {
            p = "even";
        } else if ((t%2) != 0) {
            p = "odd";
        }
        return p;
    }
}
