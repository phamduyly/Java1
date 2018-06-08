import javax.swing.*;

public class IFdemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age, yearBorn;
		age = Integer.parseInt(JOptionPane.showInputDialog("How old are you?"));
		if (age < 0) {
		age = Integer.parseInt(JOptionPane.showInputDialog("Age must be positive! Re-enter:"));
		}
		yearBorn = 2017 - age;
		JOptionPane.showMessageDialog(null, "You were born in " + yearBorn);
		
		
	}

}
