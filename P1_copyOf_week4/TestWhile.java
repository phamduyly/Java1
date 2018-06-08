import java.util.*;
public class TestWhile
{  public static void main (String[] args)
   {  int num, sum = 0;
      Scanner console = new Scanner(System.in);
      System.out.print("Enter numbers to sum.");
      System.out.print("Enter -ve number to terminate ");
      num = console.nextInt();	
      while ( num >= 0) 
      {
	     sum += num;
         System.out.print("Enter -ve number to terminate ");
         num = console.nextInt(); 
      }
      System.out.println("Sum of all +ve numbers = " + sum);
   }
}
