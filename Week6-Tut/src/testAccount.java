
public class testAccount {
	public static void main(String args[])
	{
		
		/*Account mum = new Account("s123","Mercy Brown",1000.0);
		Account dad = new Account("s124","Mercy Bro1n",2000.0);
		*/
		Account [] accountArray = new Account[2];
		accountArray[0] = new Account("0","Mercy Brown",1000.0);
		accountArray[1] = new Account("1","Mercy Bro1n",2000.0);
		
		
		if ( accountArray[0].withdraw(100)) 
			System.out.println("0 withdraw DONE");
			
		else System.out.println("Insufficient funds");
		
		accountArray[1].deposit(150); // Deposit 150 ==> + 150 
		System.out.println(" 1 Deposit done");
		if ( accountArray[1].transfer(accountArray[0],500))
			System.out.println("done");
			
		else System.out.println("Insufficient funds");
		//This else actually work
		
		System.out.println("Balance for " + accountArray[0].getID() + " = " + accountArray[0].getBalance());
		System.out.println("Balance for " + accountArray[1].getID() + " = " + accountArray[1].getBalance());
		/*
		System.out.println(accountArray[0].getName() + " balance is " + accountArray[0].getBalance());
		System.out.println(accountArray[1].getName() + " balance is " + accountArray[1].getBalance());
		accountArray[0].deposit(100);
		System.out.println(accountArray[0].getName() + " balance  after deposit is " + accountArray[0].getBalance());
		accountArray[0].withdraw(100);
		System.out.println(accountArray[0].getName() + " balance after withdraw is " + accountArray[0].getBalance());*/
	}
}

	

