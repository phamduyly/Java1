import java.util.*;
public class RainFall 
{
   public static void main(String[] args)  
   {
      Scanner sc = new Scanner(System.in);
      double[] fall = new double[12];
      for (int i = 0 ; i < 12 ; i++)  
      {
	     System.out.print("Enter rainfall for month "  + (i+1) + ": ");
   	     fall[i] = sc.nextDouble();
      }
      System.out.println("R.Fall Reverse Order ");
      for ( int i = 11;  i>=0    ;  i--)  
      {
	      System.out.println(fall[i]);
      }

   }
}