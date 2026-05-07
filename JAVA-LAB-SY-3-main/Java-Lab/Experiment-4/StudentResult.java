// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 3: Implementation of stack/queue operations using Interface
// Program 3: Student Exam Results using Inheritance and Interface

// ===================== Interface =====================
interface Sports {
    double sMarks = 0;   // constant (implicitly public static final)
    void setSportsMarks(double sm);
}

// ===================== Level 1: Base Class =====================
class Student {
    private int rollNo;

    // Setter
    public void setRollNo(int r) {
        rollNo = r;
    }

    // Getter
    public int getRollNo() {
        return rollNo;
    }
}

// ===================== Level 2: Inherits Student =====================
class Test extends Student {
    private double sub1, sub2;

    // Setter
    public void setMarks(double s1, double s2) {
        sub1 = s1;
        sub2 = s2;
    }

    // Getter
    public double getSub1() { return sub1; }
    public double getSub2() { return sub2; }
}

// ===================== Level 3: Inherits Test + implements Sports =====================
class Result extends Test implements Sports {
    private double sportsMarks;

    // Implementing Sports interface method
    @Override
    public void setSportsMarks(double sm) {
        sportsMarks = sm;
    }

    // Display all results
    public void displayResult() {
        double total      = getSub1() + getSub2() + sportsMarks;
        double percentage = total / 3;

        System.out.println("\n========== Student Result ==========");
        System.out.println("Roll No         : " + getRollNo());
        System.out.println("Subject 1 Marks : " + getSub1());
        System.out.println("Subject 2 Marks : " + getSub2());
        System.out.println("Sports Marks    : " + sportsMarks);
        System.out.println("------------------------------------");
        System.out.println("Total Marks     : " + total);
        System.out.printf ("Percentage      : %.2f%%%n", percentage);

        if (percentage >= 40)
            System.out.println("Result          : PASS ✓");
        else
            System.out.println("Result          : FAIL ✗");
        System.out.println("====================================");
    }
}

// ===================== Test Application =====================
public class StudentResult {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        Result r = new Result();

        // Setting roll number (Student class method)
        System.out.print("Enter Roll No        : ");
        r.setRollNo(sc.nextInt());

        // Setting subject marks (Test class method)
        System.out.print("Enter Subject 1 Marks: ");
        double s1 = sc.nextDouble();
        System.out.print("Enter Subject 2 Marks: ");
        double s2 = sc.nextDouble();
        r.setMarks(s1, s2);

        // Setting sports marks (Sports interface method)
        System.out.print("Enter Sports Marks   : ");
        r.setSportsMarks(sc.nextDouble());

        // Display result (Result class method)
        r.displayResult();

        // Demonstrating getter methods
        System.out.println("\n-- Getter Method Demo --");
        System.out.println("getRollNo() → " + r.getRollNo());
        System.out.println("getSub1()   → " + r.getSub1());
        System.out.println("getSub2()   → " + r.getSub2());

        sc.close();
    }
}
