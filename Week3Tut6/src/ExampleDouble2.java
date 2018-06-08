
import static java.lang.System.out;

/*
 * This example source code demonstrates the use of  
 * sum(double a,double b) method of Double class
 */

public class ExampleDouble2 {

	public static void main(String[] args) {

		Double val1 = 5.95;
		Double val2 = 0.0 / 0.0;
		Double val3 = 9.0 / 0;
		Double val4 = -val1 / 0.0;
		Double val5 = -9.25;
		Double val6 = 0.0;

		/*
		 * test all the possible scenario on using the
		 * sum(double a,double b) method
		 * Note, this only works using java 8
		 */

		out.println("Sum of "+val1+" and "+val2+ " = "
				+ Double.sum(val1, val2));
		out.println("Sum of "+val1+" and "+val3+ " = "
				+ Double.sum(val1, val3));
		out.println("Sum of "+val3+" and "+val4+ " = "
				+ Double.sum(val3, val4));		
		out.println("Sum of "+val1+" and "+val5+ " = "
				+ Double.sum(val1, val5));
		out.println("Sum of "+val2+" and "+val6+ " = "
				+ Double.sum(val2, val6));

		
//URL: 	http://javatutorialhq.com/java/lang/double-class-tutorial/sum-method-example/
	}
}