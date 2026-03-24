package hexaware;

import java.util.ArrayList;
import java.util.List;
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
public class CustomerOperation {
	
	List<Customer> customers = new ArrayList<>();
	public void createAccount(Customer c) {
		customers.add(c);
		System.out.println("Account created successfully!");
	}
	public Customer searchCustomer(int accno) {
		for(Customer c : customers) {
			if(c.getAccountNumber()==accno) {
				return c;
			}
		}
		return null;
	}
	
	public void deposit(int accno, double amt) {
		Customer c = searchCustomer(accno);
		if(c!=null) {
			c.setBalance(c.getBalance()+amt);
			System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Account not found!");
        }
	}
	
	public void withdraw(int accno, double amt) {
		Customer c = searchCustomer(accno);
		if(c!=null&&c.getBalance()>amt) {
			System.out.println("Withdrawal successful!");
        } else {
        System.out.println("Withdrawal failed!");
        }
	}
	
	public void enquireBal(int accno) {
		Customer c = searchCustomer(accno);
		if(c!=null) {
			System.out.println("Balance: "+c.getBalance());
		}else {
		System.out.println("Account Not Found!");
		}
	}
	
	public void transferAmt(int sender,int receiver,double amt) {
		Customer c1 = searchCustomer(sender);
		Customer c2 = searchCustomer(receiver);
		if(c1!=null&&c2!=null&&c1.getBalance()>amt) {
			c1.setBalance(c1.getBalance()-amt);
			c2.setBalance(c2.getBalance()+amt);
			System.out.println("Transfer successful!");
        } else {
        System.out.println("Transaction failed!");
        }
	}
	
	public void displayAll() {
		for (Customer c : customers) {
            System.out.println("Acc No: " + c.getAccountNumber() +
                    ", Name: " + c.getName() +
                    ", Balance: " + c.getBalance() +
                    ", Type: " + c.getAccountType() +
                    ", Email: " + c.getEmail());
        }
    }
}
