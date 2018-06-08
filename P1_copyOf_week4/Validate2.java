import java.util.*;
public class Validate2
{  
   public static void main(String args[])
   {   
       Scanner console=new Scanner(System.in);
       String name;        
       char gender;
       System.out.print("Enter your name : ");
       name = console.nextLine();
       do {
          System.out.print("Enter gender (M/F) :");
  	       gender = console.nextLine().charAt(0);  		
       } while ( gender != 'F' && gender != 'M' );
	   if ( gender == 'M')
          System.out.print("Welcome Mr. " + name);
       else 
          System.out.print("Welcome Ms. " + name);
   }
}
