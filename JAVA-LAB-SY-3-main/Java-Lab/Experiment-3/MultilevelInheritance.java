// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 2: Design and develop programs for different types of inheritance
// Program 4: Multilevel Inheritance — Student → Test → Result

import java.util.Scanner;

// Level 1 — Base class
class Student {
    int rollNo;
    String name;

    void getStudent(int r, String n) {
        rollNo = r;
        name = n;
    }

    void displayStudent() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
    }
}

// Level 2 — Inherits Student
class Test extends Student {
    double sub1, sub2;

    void getMarks(double s1, double s2) {
        sub1 = s1;
        sub2 = s2;
    }

    void displayMarks() {
        System.out.println("Subject 1 Marks : " + sub1);
        System.out.println("Subject 2 Marks : " + sub2);
    }
}

// Level 3 — Inherits Test
class Result extends Test {
    double total;
    double percentage;

    void calculate() {
        total      = sub1 + sub2;
        percentage = total / 2;
    }

    void displayResult() {
        displayStudent();
        displayMarks();
        System.out.println("Total           : " + total);
        System.out.println("Percentage      : " + percentage + "%");
        if (percentage >= 40)
            System.out.println("Result          : PASS");
        else
            System.out.println("Result          : FAIL");
    }
}

// Main class
public class MultilevelInheritance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Result r = new Result();

        System.out.print("Enter Roll No : ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name    : ");
        String name = sc.nextLine();

        System.out.print("Enter Marks for Subject 1 : ");
        double s1 = sc.nextDouble();

        System.out.print("Enter Marks for Subject 2 : ");
        double s2 = sc.nextDouble();

        r.getStudent(roll, name);
        r.getMarks(s1, s2);
        r.calculate();

        System.out.println("\n===== Student Result =====");
        r.displayResult();

        sc.close();
    }
}
