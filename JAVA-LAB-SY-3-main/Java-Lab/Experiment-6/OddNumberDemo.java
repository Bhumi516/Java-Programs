// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 5: Implementation of Exception Handling
// Program 2: Custom OddNumberException

// ===================== Custom Exception =====================
class OddNumberException extends Exception {
    private int number;

    OddNumberException(int number) {
        super("OddNumberException: " + number + " is an odd number!");
        this.number = number;
    }

    int getNumber() { return number; }
}

// ===================== Number Checker Class =====================
class NumberChecker {

    // Method throws OddNumberException if number is odd
    void checkEven(int number) throws OddNumberException {
        if (number % 2 != 0) {
            throw new OddNumberException(number);
        }
        System.out.println(number + " is an even number. ✓");
    }
}

// ===================== Main Application =====================
public class OddNumberDemo {
    public static void main(String[] args) {

        NumberChecker nc = new NumberChecker();
        int[] numbers = { 4, 7, 12, 9, 20, 3 };

        System.out.println("========== Odd Number Exception Demo ==========\n");

        for (int num : numbers) {
            System.out.print("Checking " + num + " → ");
            try {
                nc.checkEven(num);
            } catch (OddNumberException e) {
                System.out.println("Exception Caught: " + e.getMessage());
            } finally {
                System.out.println("  (finally block executed for " + num + ")");
            }
            System.out.println();
        }

        // User input demo
        System.out.println("========== User Input Demo ==========");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = sc.nextInt();

        try {
            nc.checkEven(input);
        } catch (OddNumberException e) {
            System.out.println("Exception Caught: " + e.getMessage());
            System.out.println("Odd number entered was: " + e.getNumber());
        } finally {
            System.out.println("Program execution complete.");
        }

        sc.close();
    }
}
