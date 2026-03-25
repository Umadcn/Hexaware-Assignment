package librarymanagement;

public class Book {

	private int id;
	private String title;
	private String author;
	private boolean issued;
	
	public Book() {}

	public Book(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.issued = false;
	}

	public int getId() {
		return id;
	}

	public boolean isIssued() {
		return issued;
	}

	public void setIssued(boolean issued) {
		this.issued = issued;
	}

	public void update(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public void display() {
		System.out.println("ID: " + id + " | " + title + " | " + author + " | " + (issued ? "Issued" : "Available"));
	}
}
