package librarymanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Member {

	private int id;
	private String name;
	private List<IssuedBook> issuedBooks = new ArrayList<>();

	public Member(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<IssuedBook> getIssuedBooks() {
		return issuedBooks;
	}

	public void issueBook(int bookId, int dueDays) {
		LocalDateTime now = LocalDateTime.now();
		issuedBooks.add(new IssuedBook(bookId, now, now.plusDays(dueDays)));
	}

	public IssuedBook returnBook(int bookId) {
		Iterator<IssuedBook> it = issuedBooks.iterator();
		while (it.hasNext()) {
			IssuedBook b = it.next();
			if (b.bookId == bookId) {
				it.remove();
				return b;
			}
		}
		return null;
	}

	public boolean hasBook(int bookId) {
		return issuedBooks.stream().anyMatch(b -> b.bookId == bookId);
	}

	public void showIssuedBooks() {
		if (issuedBooks.isEmpty()) {
			System.out.println("No books issued.");
			return;
		}

		for (IssuedBook b : issuedBooks) {
			System.out.println("BookID: " + b.bookId + " | Issued: " + b.issueDate + " | Due: " + b.dueDate);
		}
	}

	public void display() {
		System.out.println("Member ID: " + id + " | Name: " + name);
		showIssuedBooks();
	}

	static class IssuedBook {
		int bookId;
		LocalDateTime issueDate;
		LocalDateTime dueDate;

		IssuedBook(int bookId, LocalDateTime issueDate, LocalDateTime dueDate) {
			this.bookId = bookId;
			this.issueDate = issueDate;
			this.dueDate = dueDate;
		}
	}

}
