public class Conversion
{
   public static void main(String args[])
   {
      double cubicCm;		
      int finish, step;
      // constant conversion factor C.I to C.C
      final double CONV_FACTOR = 1000.0/61.0;
 
      finish = 10; step = 2;
      System.out.println("TABLE C.I TO C.C");
      for ( int i = finish; i > 0 ; i--)  
      {  
          cubicCm = (i * step) * CONV_FACTOR;
          System.out.printf("%d  %8.2f\n" ,(i*step), cubicCm);
      }
   }
}