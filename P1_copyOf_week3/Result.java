import java.util.*;
public class Result
{
   public static void main(String args[])
   {
      
      Scanner sc = new Scanner(System.in);

      // Get input
      System.out.print("Enter coursework mark : ");
      int cw = sc.nextInt();
      System.out.print("Enter exam mark : ");
      int exam = sc.nextInt();

      // Compute overall mark
      int overall = (cw + exam) / 2;

      //  Compute grade
      String grade;
      if ( overall >= 50)
          grade = "Pass";
      else
          grade = "Fail";

      //  Print the results
      System.out.println("Overall = " + overall +
                                         " Grade = " + grade);
   }
}