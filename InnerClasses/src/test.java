
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getLarge(10,20));
		

	}
	
	public static int getLarge(int x, int y) {
		
		if ( x > y) 
			return x;
		else if (x==y) 
			return -1;
		else 
			return y;
		
	}

}
