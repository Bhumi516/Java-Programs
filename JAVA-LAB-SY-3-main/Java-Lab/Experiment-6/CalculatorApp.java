// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 5: Implementation of Exception Handling
// Program 3: CalculatorApp — uses ExceptionHandlingDemo package
//
// HOW TO COMPILE AND RUN:
//   Step 1: javac -d . ExceptionHandlingDemo/DivisionException.java
//   Step 2: javac -d . ExceptionHandlingDemo/Calculator.java
//   Step 3: javac CalculatorApp.java
//   Step 4: java CalculatorApp

import ExceptionHandlingDemo.Calculator;
import ExceptionHandlingDemo.DivisionException;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println("========== Calculator with DivisionException ==========\n");

        // Test Case 1: Valid division
        System.out.println("-- Test 1: 20 / 4 --");
        try {
            double result = calc.divide(20, 4);
            System.out.println("Result: " + result);
        } catch (DivisionException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } finally {
            System.out.println("Operation complete.\n");
        }

        // Test Case 2: Division by zero — triggers DivisionException
        System.out.println("-- Test 2: 15 / 0 --");
        try {
            double result = calc.divide(15, 0);
            System.out.println("Result: " + result);
        } catch (DivisionException e) {
            System.out.println("Exception Caught : " + e.getMessage());
            System.out.println("Dividend         : " + e.getDividend());
            System.out.println("Divisor          : " + e.getDivisor());
        } finally {
            System.out.println("Operation complete.\n");
        }

        // Test Case 3: Division by zero with negative number
        System.out.println("-- Test 3: -8 / 0 --");
        try {
            double result = calc.divide(-8, 0);
            System.out.println("Result: " + result);
        } catch (DivisionException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } finally {
            System.out.println("Operation complete.\n");
        }

        // Other operations (no exception)
        System.out.println("-- Other Operations (10, 3) --");
        System.out.println("Addition       : " + calc.add(10, 3));
        System.out.println("Subtraction    : " + calc.subtract(10, 3));
        System.out.println("Multiplication : " + calc.multiply(10, 3));

        // User input demo
        System.out.println("\n========== User Input Demo ==========");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter dividend : ");
        int a = sc.nextInt();
        System.out.print("Enter divisor  : ");
        int b = sc.nextInt();

        try {
            double result = calc.divide(a, b);
            System.out.println("Result         : " + a + " / " + b + " = " + result);
        } catch (DivisionException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } finally {
            System.out.println("Program execution complete.");
        }

        sc.close();
    }
}
