import java.util.Scanner;

public class compareStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("input string x to compare: ");
		String x = sc.nextLine();
		System.out.println("input string y to compare: ");
		Scanner sc1 = new Scanner(System.in);
		String y = sc1.nextLine();
		
		if (x.contains(y)) {
			System.out.println(" x contains y ");
		} else {
			System.out.println("x do not contains y");
		}
		
	}

}
