import java.util.Scanner;

public class IntComp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input x to compare: ");
		int x = sc.nextInt();
		System.out.println("input y to compare: ");
		Scanner sc1 = new Scanner(System.in);
		int y = sc1.nextInt();
		
		if (x > y) {
			System.out.println(" x > y ");
		} else if (x < y) {
			System.out.println("x < y");
		} else {
			System.out.println("x = y");
		}
	}

}
