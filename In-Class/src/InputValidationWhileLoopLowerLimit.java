import javax.swing.*;

public class InputValidationWhileLoopLowerLimit {
	public static void main(String[] args) {
		int age, yearBorn;
		
		age = Integer.parseInt(JOptionPane.showInputDialog("How old are you?"));
		
		while (age < 0) {
		age = Integer.parseInt(JOptionPane.showInputDialog("Age must be positive! Re-enter:"));
		}
		yearBorn = 2017 - age;
		JOptionPane.showMessageDialog(null, "You were born in " + yearBorn);
}
}