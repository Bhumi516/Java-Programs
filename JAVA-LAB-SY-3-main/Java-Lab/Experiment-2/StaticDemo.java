// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 1: Implementation of a problem statement using class and object
// Program 3: Demonstrate static variables, static blocks, and static methods

public class StaticDemo {

    // Static variable
    static int count;

    // Static block — executed once when class is loaded
    static {
        System.out.println("Static block executed.");
        count = 10;   // initializing static variable
    }

    // Static method
    static void display() {
        System.out.println("Static method called.");
        System.out.println("Value of count: " + count);
    }

    public static void main(String[] args) {

        System.out.println("Main method started.");

        // Calling static method
        display();

        // Modifying static variable
        count = 20;
        System.out.println("Updated value of count: " + count);
    }
}
