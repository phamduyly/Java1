
public class Account {
	private String name;
	private double balance;
	private String accID;
	
	public Account(String accountID, String accountName, double amount)
	{
		accID = accountID;
		name = accountName;
		balance = amount;
		 
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getID(){
		return accID; 
	}
	
	public String getName(){
		return name;
	}
	public void deposit(double amount) {
		balance += amount; 
		
	}
	

	public boolean withdraw(double amount) {
		if (amount < balance) {
			balance -= amount;
			return true;
		} 
		return false;		 
		
	}

	public boolean transfer(Account other, double amount) {
	    if (amount < balance) {
	        balance -= amount;
	        
	        other.balance = other.getBalance() + amount;
	        return true;
	    }
	    return false;
	}


}

