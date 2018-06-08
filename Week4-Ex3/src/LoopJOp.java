import javax.swing.JOptionPane;

public class LoopJOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer;
		answer = JOptionPane.showInputDialog("Input into this you answer:");
		while (!answer.contains("cancel")) {
			System.out.println("this is your input: "+answer);
			answer = JOptionPane.showInputDialog("Please input again your aswer:");
		}
	}

}
