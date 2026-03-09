// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 4: Implement a program for creation of user defined packages and its use.
//
// HOW TO COMPILE AND RUN:
//   Step 1: javac -d . mypackage/MathUtils.java
//   Step 2: javac PackageDemo.java
//   Step 3: java PackageDemo

import java.util.Scanner;
import mypackage.MathUtils;

public class PackageDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MathUtils mu = new MathUtils();

        System.out.print("Enter first number : ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("\nAddition       : " + mu.add(a, b));
        System.out.println("Subtraction    : " + mu.subtract(a, b));
        System.out.println("Multiplication : " + mu.multiply(a, b));
        System.out.println("Division       : " + mu.divide(a, b));

        sc.close();
    }
}
