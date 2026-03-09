// Name   : Arhan Gaiban
// Roll No: 43
// Experiment 4: User Defined Packages
// Program 1: LibraryManagement Package — Member Class

package LibraryManagement;

import java.util.ArrayList;

// ===================== Member Class =====================
public class Member {
    private int memberId;
    private String name;
    private String contact;
    private ArrayList<Book> borrowedBooks;

    public Member(int memberId, String name, String contact) {
        this.memberId     = memberId;
        this.name         = name;
        this.contact      = contact;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public int    getMemberId() { return memberId; }
    public String getName()     { return name; }
    public String getContact()  { return contact; }

    // Borrow a book
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println("  ✓ " + name + " borrowed \"" + book.getTitle() + "\" successfully.");
        } else {
            System.out.println("  ✗ \"" + book.getTitle() + "\" is not available.");
        }
    }

    // Return a book
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true);
            System.out.println("  ✓ " + name + " returned \"" + book.getTitle() + "\" successfully.");
        } else {
            System.out.println("  ✗ This book was not borrowed by " + name);
        }
    }

    // Display member details
    public void displayMember() {
        System.out.println("  Member ID      : " + memberId);
        System.out.println("  Name           : " + name);
        System.out.println("  Contact        : " + contact);
        System.out.println("  Books Borrowed : " + borrowedBooks.size());
        if (!borrowedBooks.isEmpty()) {
            for (Book b : borrowedBooks)
                System.out.println("    - " + b.getTitle());
        }
    }
}
