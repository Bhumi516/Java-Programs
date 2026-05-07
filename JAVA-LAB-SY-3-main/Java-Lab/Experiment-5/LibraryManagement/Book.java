// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 4: User Defined Packages
// Program 1: LibraryManagement Package
//
// HOW TO COMPILE AND RUN:
//   Step 1: javac -d . LibraryManagement.java
//   Step 2: javac -d . LibrarySystem.java
//   Step 3: java LibrarySystem

package LibraryManagement;

// ===================== Book Class =====================
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    public Book(String title, String author, String ISBN) {
        this.title       = title;
        this.author      = author;
        this.ISBN        = ISBN;
        this.isAvailable = true;
    }

    // Getters
    public String getTitle()   { return title; }
    public String getAuthor()  { return author; }
    public String getISBN()    { return ISBN; }
    public boolean isAvailable() { return isAvailable; }

    // Setters
    public void setAvailable(boolean status) { isAvailable = status; }

    public void displayBook() {
        System.out.println("  Title     : " + title);
        System.out.println("  Author    : " + author);
        System.out.println("  ISBN      : " + ISBN);
        System.out.println("  Available : " + (isAvailable ? "Yes" : "No"));
    }
}
