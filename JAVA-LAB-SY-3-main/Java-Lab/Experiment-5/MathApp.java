// Name   : Bhumi Bhadre
// Roll No: 31
// Experiment 4: User Defined Packages
// Program 3: MathApp — uses MathOperations package
//
// HOW TO COMPILE AND RUN:
//   Step 1: javac -d . MathOperations/MathFunctions.java
//   Step 2: javac MathApp.java
//   Step 3: java MathApp

import MathOperations.MathFunctions;

public class MathApp {
    public static void main(String[] args) {

        MathFunctions mf = new MathFunctions();

        double[] numbers = { 4.3, 7.8, -2.5, 9.1, -6.7 };

        System.out.println("====================================================");
        System.out.printf("%-10s %-10s %-10s %-10s%n", "Number", "Floor", "Ceil", "Round");
        System.out.println("====================================================");

        for (double num : numbers) {
            System.out.printf("%-10.1f %-10.0f %-10.0f %-10d%n",
                num,
                mf.floor(num),
                mf.ceil(num),
                mf.round(num));
        }

        System.out.println("====================================================");

        // Additional math operations
        System.out.println("\n========== Additional Operations ==========");

        double base = 3.0, exp = 4.0;
        System.out.println("Power (" + base + "^" + exp + ")   : " + mf.power(base, exp));

        double sqrtNum = 144.0;
        System.out.println("Square Root (" + sqrtNum + ") : " + mf.sqrt(sqrtNum));

        double negNum = -25.75;
        System.out.println("Absolute (" + negNum + ")  : " + mf.absolute(negNum));
    }
}
