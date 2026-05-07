// Name   : Bhumi Bhadre
// Roll No: 31
// Experiment 4: User Defined Packages
// Program 1: LibrarySystem — uses LibraryManagement package
//
// HOW TO COMPILE AND RUN:
//   Step 1: javac -d . LibraryManagement/Book.java
//   Step 2: javac -d . LibraryManagement/Member.java
//   Step 3: javac LibrarySystem.java
//   Step 4: java LibrarySystem

import LibraryManagement.Book;
import LibraryManagement.Member;

public class LibrarySystem {
    public static void main(String[] args) {

        // Creating books
        Book b1 = new Book("Java Programming",        "James Gosling",   "ISBN001");
        Book b2 = new Book("Data Structures",         "Mark Weiss",      "ISBN002");
        Book b3 = new Book("Operating Systems",       "Silberschatz",    "ISBN003");

        // Creating members
        Member m1 = new Member(101, "Atharv Kate",  "9876543210");
        Member m2 = new Member(102, "Riya Sharma",  "9123456780");

        // Display all books
        System.out.println("========== Library Books ==========");
        System.out.println("Book 1:"); b1.displayBook();
        System.out.println("Book 2:"); b2.displayBook();
        System.out.println("Book 3:"); b3.displayBook();

        // Display members
        System.out.println("\n========== Members ==========");
        System.out.println("Member 1:"); m1.displayMember();
        System.out.println("Member 2:"); m2.displayMember();

        // Borrow books
        System.out.println("\n========== Borrowing Books ==========");
        m1.borrowBook(b1);
        m1.borrowBook(b2);
        m2.borrowBook(b2);   // already borrowed — should show not available
        m2.borrowBook(b3);

        // Display after borrowing
        System.out.println("\n========== After Borrowing ==========");
        System.out.println("Member 1:"); m1.displayMember();
        System.out.println("Member 2:"); m2.displayMember();

        // Return a book
        System.out.println("\n========== Returning Books ==========");
        m1.returnBook(b1);

        // Display after return
        System.out.println("\n========== After Returning ==========");
        System.out.println("Book 1:"); b1.displayBook();
        System.out.println("Member 1:"); m1.displayMember();
    }
}
