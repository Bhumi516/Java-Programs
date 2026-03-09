// Name   : Bhumi Bhadre
// Roll No: 31
// Experiment 4: User Defined Packages
// Program 3: MathOperations Package

package MathOperations;

public class MathFunctions {

    // Floor — largest integer less than or equal to the number
    public double floor(double num) {
        return Math.floor(num);
    }

    // Ceil — smallest integer greater than or equal to the number
    public double ceil(double num) {
        return Math.ceil(num);
    }

    // Round — rounds to nearest integer
    public long round(double num) {
        return Math.round(num);
    }

    // Square root
    public double sqrt(double num) {
        return Math.sqrt(num);
    }

    // Power
    public double power(double base, double exp) {
        return Math.pow(base, exp);
    }

    // Absolute value
    public double absolute(double num) {
        return Math.abs(num);
    }
}
