// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 2: Design and develop programs for different types of inheritance
// Program 1: Single Inheritance — BankAccount → SavingsAccount

import java.util.*;

// Base class
class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Current Balance: " + balance);
    }

    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
        System.out.println("Current Balance: " + balance);
    }
}

// Single Inheritance — SavingsAccount overrides withdraw
class SavingsAccount extends BankAccount {

    SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    void withdraw(double amount) {
        if (balance - amount < 100) {
            System.out.println("Withdrawal denied. Balance cannot fall below Rs.100.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Current Balance: " + balance);
        }
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        SavingsAccount sa = new SavingsAccount(sc.nextDouble());

        System.out.print("Enter deposit amount: ");
        sa.deposit(sc.nextDouble());

        System.out.print("Enter withdrawal amount: ");
        sa.withdraw(sc.nextDouble());

        sc.close();
    }
}
