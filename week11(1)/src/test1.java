import javax.swing.JOptionPane;

public class test1 {

    public static void main(String[] args) {
        test1 testObj = new test1();
    }
   
    public test1() {
        int t = Integer.parseInt(JOptionPane.showInputDialog("input number"));
    	System.out.println(getSignAndParity(t));
    	
    }
    public String getSignAndParity(int t) {
        String y = null;
        String q= null; 	  	
    	if (t < 0 ) 
    	{
    		y = "positive";
    	} else if (t> 0) {
    		y = "negative";
    	} 
    	//can actually do 2 if here and java will run through all it 
    	if ((t%2)==0) {
    		q = "odd";
    	} else if ((t%2) != 0){
    		q = " not odd";
    	}    	
		String e = y +" "+ q;
        //String e = y + " " +q;
        return e;
    }

    static String x;
    private static String checkSign(int t) {
        if (t < 0) {
            x = "Negative";
        } else if (t > 0) {
            x = "positive";
        }

        return x;

    }

    static String p;
    private static String checkOdd(int t) {
        if ((t%2) == 0) {
            p = "even";
        } else if ((t%2) != 0) {
            p = "odd";
        }
        return p;
    }
}
