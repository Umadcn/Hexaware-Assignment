package librarymanagement;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Library {
	
	private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, Member> members = new HashMap<>();

    private int bookIdCounter = 1;
    private int memberIdCounter = 1;

    private int dueDays = 7;

    public void addBook(String title, String author) {
        Book b = new Book(bookIdCounter++, title, author);
        books.put(b.getId(), b);
        System.out.println("Book added with ID: " + b.getId());
    }

    public void addMember(String name) {
        Member m = new Member(memberIdCounter++, name);
        members.put(m.getId(), m);
        System.out.println("Member added with ID: " + m.getId());
    }
    
    public void removeBook(int bookId) {
        Book b = books.get(bookId);

        if (b == null) {
            System.out.println("Book not found!");
            return;
        }

        if (b.isIssued()) {
            System.out.println("Cannot remove issued book!");
            return;
        }

        books.remove(bookId);
        System.out.println("Book removed successfully.");
    }
    
    public void updateBook(int bookId, String newTitle, String newAuthor) {
        Book b = books.get(bookId);

        if (b == null) {
            System.out.println("Book not found!");
            return;
        }

        b.update(newTitle, newAuthor);
        System.out.println("Book updated successfully.");
    }
    
    public void removeMember(int memberId) {
        Member m = members.get(memberId);

        if (m == null) {
            System.out.println("Member not found!");
            return;
        }

        if (!m.getIssuedBooks().isEmpty()) {
            System.out.println("Member has issued books! Cannot delete.");
            return;
        }

        members.remove(memberId);
        System.out.println("Member removed successfully.");
    }

    public void issueBook(int memberId, int bookId) {
        Member m = members.get(memberId);
        Book b = books.get(bookId);

        if (m == null || b == null) {
            System.out.println("Invalid IDs!");
            return;
        }

        if (b.isIssued()) {
            System.out.println("Book already issued!");
            return;
        }

        m.issueBook(bookId, dueDays);
        b.setIssued(true);

        System.out.println("Book issued successfully.");
    }

    public void returnBook(int memberId, int bookId) {
        Member m = members.get(memberId);
        Book b = books.get(bookId);

        if (m == null || b == null) {
            System.out.println("Invalid IDs!");
            return;
        }

        Member.IssuedBook ib = m.returnBook(bookId);
        if (ib == null) {
            System.out.println("Book not issued!");
            return;
        }

        long lateDays = ChronoUnit.DAYS.between(ib.dueDate, LocalDateTime.now());

        if (lateDays > 0) {
            long fine = calculateFine(lateDays);
            System.out.println("Late by " + lateDays + " days. Fine: ₹" + fine);
        } else {
            System.out.println("Returned on time.");
        }

        b.setIssued(false);
    }

    private long calculateFine(long days) {
        if (days <= 5) return days * 10;
        return (5 * 10) + ((days - 5) * 20);
    }

    public void showBooks() {
        books.values().forEach(Book::display);
    }

    public void showMembers() {
        members.values().forEach(Member::display);
    }

    public void showOverdue() {
        LocalDateTime now = LocalDateTime.now();

        for (Member m : members.values()) {
            for (Member.IssuedBook b : m.getIssuedBooks()) {
                if (b.dueDate.isBefore(now)) {
                    System.out.println("Member: " + m.getName() +
                            " | BookID: " + b.bookId +
                            " | Due: " + b.dueDate);
                }
            }
        }
    }

    public void setDueDays(int days) {
        this.dueDays = days;
    }
}
