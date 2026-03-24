package hexawareassignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Employee> employees = new ArrayList<>();

	public static void main(String[] args) {
		int choice;

		do {
			System.out.println("\n===== Employee Management System =====");
			System.out.println("1. Add Temporary Employee");
			System.out.println("2. Add Permanent Employee");
			System.out.println("3. Display All Employees");
			System.out.println("4. Calculate Salaries");
			System.out.println("5. Search Employee by ID");
			System.out.println("6. Update Employee Salary Details");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				addTemporaryEmployee();
				break;
			case 2:
				addPermanentEmployee();
				break;
			case 3:
				displayAllEmployees();
				break;
			case 4:
				calculateAllSalaries();
				break;
			case 5:
				searchEmployee();
				break;
			case 6:
				updateEmployee();
				break;
			case 7:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 7);
	}

	public static void addTemporaryEmployee() {
		System.out.print("Enter ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Hours Worked: ");
		int hours = sc.nextInt();
		System.out.print("Enter Rate per Hour: ");
		double rate = sc.nextDouble();

		employees.add(new TemporaryEmployee(id, name, hours, rate));
		System.out.println("Temporary Employee Added!");
	}

	public static void addPermanentEmployee() {
		System.out.print("Enter ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Basic Salary: ");
		double basic = sc.nextDouble();
		System.out.print("Enter Bonus: ");
		double bonus = sc.nextDouble();

		employees.add(new PermanentEmployee(id, name, basic, bonus));
		System.out.println("Permanent Employee Added!");
	}

	public static void displayAllEmployees() {
		if (employees.isEmpty()) {
			System.out.println("No employees found!");
			return;
		}
		for (Employee e : employees) {
			e.displayDetails();
		}
	}

	public static void calculateAllSalaries() {
		if (employees.isEmpty()) {
			System.out.println("No employees found!");
			return;
		}
		for (Employee e : employees) {
			System.out.println("Employee ID: " + e.empId + " Salary: " + e.calculateSalary());
		}
	}

	static void searchEmployee() {
		System.out.print("Enter Employee ID to search: ");
		int id = sc.nextInt();

		for (Employee e : employees) {
			if (e.empId == id) {
				e.displayDetails();
				return;
			}
		}
		System.out.println("Employee not found!");
	}

	static void updateEmployee() {
		System.out.print("Enter Employee ID to update: ");
		int id = sc.nextInt();

		for (Employee e : employees) {
			if (e.empId == id) {

				if (e instanceof TemporaryEmployee) {
					TemporaryEmployee temp = (TemporaryEmployee) e;
					System.out.print("Enter new Hours Worked: ");
					temp.hoursWorked = sc.nextInt();
					System.out.print("Enter new Rate per Hour: ");
					temp.ratePerHour = sc.nextDouble();

				} else if (e instanceof PermanentEmployee) {
					PermanentEmployee perm = (PermanentEmployee) e;
					System.out.print("Enter new Basic Salary: ");
					perm.basicSalary = sc.nextDouble();
					System.out.print("Enter new Bonus: ");
					perm.bonus = sc.nextDouble();
				}

				System.out.println("Employee updated successfully!");
				return;
			}
		}
		System.out.println("Employee not found!");
	}
}
