// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 4: Implement a program for creation of user defined packages and its use.
//
// HOW TO COMPILE AND RUN:
//   Step 1: javac -d . MathUtils.java
//   Step 2: javac -d . PackageDemo.java
//   Step 3: java PackageDemo

// ---- File: mypackage/MathUtils.java ----
// (Create folder 'mypackage' and place MathUtils.java inside it)
//
// package mypackage;
//
// public class MathUtils {
//     public int add(int a, int b)      { return a + b; }
//     public int subtract(int a, int b) { return a - b; }
//     public int multiply(int a, int b) { return a * b; }
//     public double divide(int a, int b) {
//         if (b == 0) { System.out.println("Cannot divide by zero."); return 0; }
//         return (double) a / b;
//     }
// }

// ---- Main file: PackageDemo.java ----
// Demonstrates use of user-defined package

package mypackage;

public class MathUtils {
    public int add(int a, int b)       { return a + b; }
    public int subtract(int a, int b)  { return a - b; }
    public int multiply(int a, int b)  { return a * b; }
    public double divide(int a, int b) {
        if (b == 0) { System.out.println("Cannot divide by zero."); return 0; }
        return (double) a / b;
    }
}
