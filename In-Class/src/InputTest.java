import javax.swing.*;

	public class InputTest {
		public static void main(String[] args) {
			/*int val1;
			int val2;
			double answer;
			String Answers;
			
			Answers=(JOptionPane.showInputDialog("Hello, Please ask me about 1.Weather 2.Daily life 3.Social Media 4.Countries 5.Funny"));
			
			val1=Integer.parseInt( JOptionPane.showInputDialog("Enter an int; ") );
			//Question: Does the input get recognized as a string?
			//parseInt is converting 
			val2=Integer.parseInt( JOptionPane.showInputDialog("Enter another int: ") );
			answer=val1/val2;
			//JOptionPane class
				JOptionPane.showMessageDialog(null,val1+" divided by "+val2+" is "+answer);
		}*/
			String Vocabulary;
			String Vocabulary1;
			String Vocabulary2;
			String Vocabulary3;
			String Vocabulary4;
			String Vocabulary5;
			String Vocabulary6;
			String Vocabulary7;
			String Vocabulary8;
			String Vocabulary9;
			/*User answer*/
			String Answers;
			
			/*keyword*/
			Vocabulary="work";
			Vocabulary1="weather";
			Vocabulary2="youtube";
			Vocabulary3="facebook";
			Vocabulary4="missing";
			Vocabulary5="social media";
			Vocabulary6="instagram";
			Vocabulary7="sport";
			Vocabulary8="countries";
			Vocabulary9="funny";
			
			Answers=(JOptionPane.showInputDialog("Hello, Please ask me about 1.Weather 2.Daily life 3.Social Media 4.Countries 5.Funny"));
			if ( Answers.contains(Vocabulary)) {
				JOptionPane.showInputDialog("How is your work today?");
			}else if ( Answers.contains(Vocabulary1)) {
				JOptionPane.showInputDialog("How is your work today?");
			}
			else if ( Answers.contains(Vocabulary2)) {
				JOptionPane.showInputDialog("How is your work today?");
			}
			else if ( Answers.contains(Vocabulary3)) {
				JOptionPane.showInputDialog("How is your work today?");
			}
			else if ( Answers.contains(Vocabulary4)) {
				JOptionPane.showInputDialog("How is your work today?");
			}
			else if ( Answers.contains(Vocabulary5)) {
				JOptionPane.showInputDialog("How is your work today?");
			}
			else if ( Answers.contains(Vocabulary6)) {
				JOptionPane.showInputDialog("How is your work today?");
			}
			else if ( Answers.contains(Vocabulary7)) {
				JOptionPane.showInputDialog("How is your work today?");
			}
			else if ( Answers.contains(Vocabulary8)) {
				JOptionPane.showInputDialog("How is your work today?");
			}
			else if ( Answers.contains(Vocabulary9)) {
				JOptionPane.showInputDialog("How is your work today?");
			} else {
				JOptionPane.showInputDialog("Sorry, I don't know about this topic");
			}
		
		}
}
	