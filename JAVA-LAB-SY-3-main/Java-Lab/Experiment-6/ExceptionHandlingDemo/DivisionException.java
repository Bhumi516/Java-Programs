// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 5: Implementation of Exception Handling
// Program 3: ExceptionHandlingDemo Package — DivisionException Class

package ExceptionHandlingDemo;

// ===================== Custom Exception =====================
public class DivisionException extends Exception {
    private int dividend;
    private int divisor;

    public DivisionException(int dividend, int divisor) {
        super("DivisionException: Cannot divide " + dividend + " by zero!");
        this.dividend = dividend;
        this.divisor  = divisor;
    }

    public int getDividend() { return dividend; }
    public int getDivisor()  { return divisor; }
}
