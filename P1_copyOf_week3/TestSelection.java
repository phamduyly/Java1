import java.util.*;
public class TestSelection
{ 
   public static void main(String args[])
   {   
      Scanner console=new Scanner(System.in);
      String name;
      char gender;
      System.out.print("Enter your name : ");
      name = console.nextLine();
      System.out.print("Enter gender (M/F) :");
      gender = console.nextLine().charAt(0);  		
      if ( gender == 'M' || gender == 'm')
        System.out.print("Mr. " + name);	
      else
        System.out.print("Ms. " + name);	
   }
}
