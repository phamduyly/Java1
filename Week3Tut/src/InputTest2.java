import java.util.Scanner;
import java.lang.String;

public class InputTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*a. Create separate variables for at least 10 built-in keywords/topics (hard-coded in your program). E.g.
		a keyword can be ï¿½workï¿½. Arrays are not needed for this level (code will be lengthy ï¿½ aim to do normal
		functionality instead!)*/
		/*chat bot words vocabulary declaration*/
		String vocabulary="work",vocabulary1="weather", vocabulary2="youtube", vocabulary3="facebook", vocabulary4="missing", vocabulary5="instagram", vocabulary6="sport", vocabulary7="countries", vocabulary8="funny", vocabulary9="social media";
		/*User answer*/
		String name;
		System.out.println("Hi, Please enter your first name");
		Scanner sc1 = new Scanner(System.in);
		name = sc1.nextLine();
		System.out.println("Hello "+name+" , Please ask me about 1.Weather 2.Daily life 3.Social Media 4.Countries 5.Funny");
		Scanner sc = new Scanner(System.in);
		String answers = sc.nextLine();

		//Whole function start here
		//TODO: put function into method
		//TODO: re-check the '?' function.
		if (answers.contains(vocabulary) || answers.contains(vocabulary1) || answers.contains(vocabulary2) || answers.contains(vocabulary3) || answers.contains(vocabulary4) || answers.contains(vocabulary5) || answers.contains(vocabulary6) || answers.contains(vocabulary7) || answers.contains(vocabulary8) || answers.contains(vocabulary9)) {
			System.out.println("How is your " + answers + " today?");
			answers = sc.nextLine();
			while (!answers.contains("cancel")) {
				System.out.println("Keep going, I am listening? ");
				answers = sc.nextLine();
				while (answers.contains("?")) {
					System.out.println("Sorry, Only me can ask.");
					answers = sc.nextLine();
					if (answers.contains(vocabulary) || answers.contains(vocabulary1) || answers.contains(vocabulary2) || answers.contains(vocabulary3) || answers.contains(vocabulary4) || answers.contains(vocabulary5)) {
						System.out.println("How is your " + answers + " today?");
						answers = sc.nextLine();
						//TODO: check WHILE & IF cancel
						while (!answers.contains("cancel")) {
							System.out.println("Keep going, I am listening? ");
						}
					} else {
						System.out.println("Sorry, " + name + " I don't know about this topic, Please ask me about 1.Weather 2.Daily life 3.Social Media 4.Countries 5.Funny");
						answers = sc.nextLine();
						while (!answers.contains("cancel")) {
							System.out.println("Keep going, I am listening? ");
							answers = sc.nextLine();
							while (answers.contains("?")) {
								System.out.println("Sorry, Only me can ask.");
								answers = sc.nextLine();
								if (answers.contains(vocabulary) || answers.contains(vocabulary1) || answers.contains(vocabulary2) || answers.contains(vocabulary3) || answers.contains(vocabulary4) || answers.contains(vocabulary5)) {
									System.out.println("How is your " + answers + " today?");
									answers = sc.nextLine();
									//TODO: check WHILE & IF cancel
									while (!answers.contains("cancel")) {
										System.out.println("Keep going, I am listening? ");

									}
								}
							}

						}}}}}
			/*
			else {
				System.out.println("Sorry, I don't know about this topic, Please ask me about 1.Weather 2.Daily life 3.Social Media 4.Countries 5.Funny");
				answers = sc.nextLine();
				if (answers.contains(vocabulary)){
					System.out.println("How is your work today?");
					answers = sc.nextLine();
					if (answers.contains("cancel")) {
						System.exit(1);
					}
					if (answers.contains("?")) {
						System.out.println("Sorry, Only me can ask.");
						if (answers.contains("cancel")) {
							System.exit(1);
						}
					}
				}
			}*/
	}


}


