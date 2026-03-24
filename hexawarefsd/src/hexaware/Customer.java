package hexaware;
//🏦 Bank Assignment (Array Based)
//Create a Customer class with: accountNumber, name, balance, accountType, email.
//Create an array of customers.
//Write logic to:
//Create account
//Deposit amount
//Withdraw amount
//Enquiry balance
//Transfer amount
//Search customer by account number.
//Display all customers.
public class Customer {
	private int accountNumber;
	private String name;
	private double balance;
	private String accountType;
	private String email;
	
	public Customer(int accountNumber, String name, double balance, String accountType, String email) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.accountType = accountType;
		this.email = email;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + ", accountType="
				+ accountType + ", email=" + email + "]";
	}
	
	public String toString(int i) {
		return "Customer "+i+"[accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + ", accountType="
				+ accountType + ", email=" + email + "]";
	}
	
	
	
}
