/*import javax.swing.*;

public class InputTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 Object[] possibleValues = { "First", "Second", "Third" };

		 Object selectedValue1 = JOptionPane.showInputDialog(null,
		             "Choose one", "Input",
		             JOptionPane.INFORMATION_MESSAGE, null,
		             possibleValues, possibleValues[0]);
	}

}*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InputTest extends JFrame {
  public InputTest() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(new JLabel("Placeholder label"));
    pack();
    setSize(200, 200);
    setVisible(true);

    int replaced = JOptionPane.showConfirmDialog(this,
        "Replace existing selection?");

    String result = "?";
    switch (replaced) {
    case JOptionPane.CANCEL_OPTION:
      result = "Canceled";
      break;
    case JOptionPane.CLOSED_OPTION:
      result = "Closed";
      break;
    case JOptionPane.NO_OPTION:
      result = "No";
      break;
    case JOptionPane.YES_OPTION:
      result = "Yes";
      break;
    default:
      ;
    }
    System.out.println("Replace? " + result);
  }

  public static void main(String[] args) {
    new InputTest();
  }
}

   