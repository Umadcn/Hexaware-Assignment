package hexaware;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CustomerOperation custoperations = new CustomerOperation();
		custoperations.createAccount(new Customer(1, "Uma", 5000, "Savings", "uma@gmail.com"));
		custoperations.createAccount(new Customer(2, "Madhu", 3000, "Current", "madhu@gmail.com"));
		custoperations.createAccount(new Customer(3, "John", 5000, "Savings", "john@gmail.com"));
		custoperations.createAccount(new Customer(4, "Max", 3000, "Current", "max@gmail.com"));
		custoperations.createAccount(new Customer(5, "Steve", 5000, "Savings", "steve@gmail.com"));
		custoperations.createAccount(new Customer(6, "Dustin", 3000, "Current", "dustin@gmail.com"));
		custoperations.deposit(1, 1000);

		custoperations.withdraw(2, 500);

		custoperations.enquireBal(1);

		custoperations.transferAmt(1, 2, 2000);

		custoperations.displayAll();

	}
}
