package hexawareassignment2;

public class TemporaryEmployee extends Employee {

	int hoursWorked;
	double ratePerHour;

	TemporaryEmployee(int empId, String name, int hoursWorked, double ratePerHour) {
		super(empId, name);
		this.hoursWorked = hoursWorked;
		this.ratePerHour = ratePerHour;
	}

	double calculateSalary() {
		return hoursWorked * ratePerHour;
	}

	void displayDetails() {
		super.displayDetails();
		System.out.println("Temporary Employee");
		System.out.println("Hours Worked: " + hoursWorked);
		System.out.println("Rate per Hour: " + ratePerHour);
		System.out.println("Salary: " + calculateSalary());
	}

}
