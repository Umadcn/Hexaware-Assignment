package hexawareassignment2;

public class PermanentEmployee extends Employee{
	double basicSalary;
    double bonus;

    PermanentEmployee(int empId, String name, double basicSalary, double bonus) {
        super(empId, name);
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    double calculateSalary() {
        return basicSalary + bonus;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Permanent Employee");
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Salary: " + calculateSalary());
    }
}
