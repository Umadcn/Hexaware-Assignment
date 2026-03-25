package librarymanagement;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
        	System.out.println("1.Add Member \n2.Add Book \n3.Issue \n4.Return");
        	System.out.println("5.Show Books \n6.Show Members \n7.Overdue");
        	System.out.println("8.Set Due Days \n9.Remove Book \n10.Update Book \n11.Remove Member \n12.Exit");
            System.out.println("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print("Name: ");
                    lib.addMember(sc.nextLine());
                }
                case 2 -> {
                    System.out.print("Title: ");
                    String t = sc.nextLine();
                    System.out.print("Author: ");
                    String a = sc.nextLine();
                    lib.addBook(t, a);
                }
                case 3 -> {
                    System.out.print("Member ID: ");
                    int m = sc.nextInt();
                    System.out.print("Book ID: ");
                    int b = sc.nextInt();
                    lib.issueBook(m, b);
                }
                case 4 -> {
                    System.out.print("Member ID: ");
                    int m = sc.nextInt();
                    System.out.print("Book ID: ");
                    int b = sc.nextInt();
                    lib.returnBook(m, b);
                }
                case 5 -> lib.showBooks();
                case 6 -> lib.showMembers();
                case 7 -> lib.showOverdue();
                case 8 -> {
                    System.out.print("Days: ");
                    lib.setDueDays(sc.nextInt());
                }
                case 9 -> {
                    System.out.print("Book ID: ");
                    lib.removeBook(sc.nextInt());
                }
                case 10 -> {
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Title: ");
                    String t = sc.nextLine();
                    System.out.print("New Author: ");
                    String a = sc.nextLine();
                    lib.updateBook(id, t, a);
                }
                case 11 -> {
                    System.out.print("Member ID: ");
                    lib.removeMember(sc.nextInt());
                }
                case 12 -> {
                    return;
                }
            }
        }
    }
}