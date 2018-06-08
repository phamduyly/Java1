import java.util.*;
import java.lang.*;
import javax.swing.JOptionPane;

public class ChatterBot {

    public static void main(String[] args) {
        //Stage1: choose quantity
            int maxNum;
            maxNum = Integer.parseInt(JOptionPane.showInputDialog("Please input keywords quantity:"));
            // User input words step, maxNum words is 20.
            // checking if the users choose more than 20 words,
            if (maxNum > 20 || maxNum < 20) {

                // Looping asking users to input quantity again until it is under 20
                while (maxNum > 20) {
                    JOptionPane.showMessageDialog(null, "Sorry, it is too many, please choose under 20 words");
                    maxNum = Integer.parseInt(JOptionPane.showInputDialog("Please input keywords quantity:"));
                }
                // Stage2 : stored user keywords
                String[] vocabulary = new String[maxNum]; // the amount in array is = maxNum
                JOptionPane.showMessageDialog(null, "Please input " + maxNum + " words that you want to talk about: ");
                //For incremental vocabulary adding. Checking user vocabulary input
                for (int i = 0; i < maxNum; i++) {
                    vocabulary[i] = JOptionPane.showInputDialog("Input");

                    if (!vocabulary[i].equals("?")) {
                        JOptionPane.showMessageDialog(null, "I remembered it!");
                        //if user have ? than delete the ? keywords
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Sorry, keywords is not expected due to spaces or ?. Please input another keywords");
                        //Deleted the words that is not appropriate
                        vocabulary[i] = null;
                    }
                }
            // print out all the words that user input
            JOptionPane.showMessageDialog(null, "The " + maxNum + " you entered: " + Arrays.toString(vocabulary));
            /* User answer */
            String name;
            name = JOptionPane.showInputDialog("Hi, Please enter your first name");
            String answers = JOptionPane.showInputDialog("Hello " + name + " , Please ask me about " + Arrays.toString(vocabulary));
            // Whole function start here
            //Step 1: check whether there is any input. Align with 'Starting from and asking about the topic. - Only stop when user click cancel
            while (!answers.isEmpty()) {
                for (int i = 0; i < maxNum; i++) {
                    // k = i to identify matched keywords index and ask 'How' to user
                    int k = i;
                    //Step 2: if the user already talked the topic. Keep going from here until cancel.
                    while (answers.contains(vocabulary[i])) {
                        answers = JOptionPane.showInputDialog("How is your " + vocabulary[k] + " today?");
                        if (answers.isEmpty()) {
                            answers = JOptionPane.showInputDialog("Don't be silent with me");
                            //check ?
                        } else if (answers.contains("?")) {
                            answers = JOptionPane.showInputDialog("I am the boss, Only me asking");
                            //Check empty
                        } else if (!answers.isEmpty()) {
                            answers = JOptionPane.showInputDialog("I am curious");
                        }
                        //Step 3: Keep asking from here until user choose cancel in JOptionPane
                        while (!answers.isEmpty()) {
                            answers = JOptionPane.showInputDialog("keep going");
                        }
                    }
                }
                answers = JOptionPane.showInputDialog("Please talk about " + Arrays.toString(vocabulary));
            }
        }
    }
}






