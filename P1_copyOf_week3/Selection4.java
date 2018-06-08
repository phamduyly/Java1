import java.util.*;
public class Selection4
{  
   public static void main(String args[])
   {  
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter car value : ");
      double value = sc.nextDouble(); 
      System.out.print("Enter exp in months : ");
      int exp = sc.nextInt(); 
      System.out.print("Enter age of car (years) : ");
      int age = sc.nextInt(); 
      double insurance = value * 1.0 /100.0 + 200;  // 1%
      double premium;
      if (   age <= 5 )
         if ( exp >=  30 )
             premium = 100.0;
         else
             premium = 250.0;
      else 
         if ( exp >=  30 )
             premium = 150.0;
         else
             premium = 325.0;

      insurance += premium;
                               
      System.out.println("Insurance = " + insurance);
   }
}
