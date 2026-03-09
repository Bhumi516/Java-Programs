// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 5: Implementation of Exception Handling
// Program 3: ExceptionHandlingDemo Package — Calculator Class

package ExceptionHandlingDemo;

// ===================== Calculator Class =====================
public class Calculator {

    // Divide method — throws DivisionException if b is zero
    public double divide(int a, int b) throws DivisionException {
        if (b == 0) {
            throw new DivisionException(a, b);
        }
        return (double) a / b;
    }

    // Other basic operations
    public int add(int a, int b)      { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}
