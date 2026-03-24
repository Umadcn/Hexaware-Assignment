package hexawareassignment3;

public class Main {
	public static void main(String[] args) {
		int age = 150;
		try {
			validate(age);
			System.out.println("Age is valid.");
		} catch (InvalidAgeException e) {
			System.err.println("Caught: " + e.getMessage());
		}
	}

	static void validate(int age) throws InvalidAgeException {
		if (age < 18 || age > 100) {
			throw new InvalidAgeException("Age " + age + " is out of range (18-100).");
		}
	}
}
