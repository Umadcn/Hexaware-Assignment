package hexawareassignment2;

public abstract class Employee {
	int empId;
	String name;

	Employee(int empId, String name) {
		this.empId = empId;
		this.name = name;
	}

	abstract double calculateSalary();

	void displayDetails() {
		System.out.println("Employee ID: " + empId);
		System.out.println("Name: " + name);
	}
}
