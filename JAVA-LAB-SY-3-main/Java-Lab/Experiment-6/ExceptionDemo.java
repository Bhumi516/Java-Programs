// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 5: Implementation of a program for Exception Handling

import java.util.Scanner;

// Custom (user-defined) exception
class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit amount must be positive.");
        balance += amount;
        System.out.println("Deposited: " + amount + " | Balance: " + balance);
    }

    void withdraw(double amount) throws InsufficientFundsException, IllegalArgumentException {
        if (amount <= 0)
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        if (amount > balance)
            throw new InsufficientFundsException("Insufficient funds! Available balance: " + balance);
        balance -= amount;
        System.out.println("Withdrawn: " + amount + " | Balance: " + balance);
    }

    double getBalance() { return balance; }
}

public class ExceptionDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // --- Built-in exceptions ---
        System.out.println("=== ArithmeticException Demo ===");
        try {
            int a = 10, b = 0;
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.\n");
        }

        System.out.println("=== ArrayIndexOutOfBoundsException Demo ===");
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.\n");
        }

        System.out.println("=== NumberFormatException Demo ===");
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.\n");
        }

        // --- Custom exception with BankAccount ---
        System.out.println("=== Custom Exception Demo (BankAccount) ===");
        BankAccount acc = new BankAccount(500);

        try {
            acc.deposit(200);
            acc.withdraw(800);   // This will throw InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument: " + e.getMessage());
        } finally {
            System.out.println("Final balance: " + acc.getBalance());
        }

        sc.close();
    }
}
