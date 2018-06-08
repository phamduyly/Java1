import javax.swing.JOptionPane;



public class MultiplyTest {

	public static void main(String[] args) {
		// TODO: Auto-generated method stub
		int val1;
		double val2;
		double answer;
		String Greeting="Ni Hao!! ";

		val1=Integer.parseInt( JOptionPane.showInputDialog("Enter an Int") );
		val2=Double.parseDouble( JOptionPane.showInputDialog("Enter a double") );
		answer=val1*val2;
		//Step1: change from / to * 
		JOptionPane.showMessageDialog(null,Greeting+val1+" multiplied by "+val2+" is "+answer);
		
	}

}
