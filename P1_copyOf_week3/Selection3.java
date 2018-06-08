import java.util.*;
public class Selection3
{  
   public static void main(String args[])
   {  
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter weight : ");
      double weight = sc.nextDouble(); 
      if ( weight > 80.0)
         System.out.println("Over-weight"); 
      if ( weight >= 60.0 && weight <= 80.0 ) 
         System.out.println("Normal-weight"); 
      if ( weight < 60.0 )
        System.out.println("Under-weight"); 
 
   }
}
