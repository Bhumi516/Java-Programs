// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 1: Implementation of a problem statement using class and object
// Program 1: Employee class with yearly salary and 10% raise

import java.util.*;

class Employee {

    String firstName;
    String lastName;
    double salary;

    Employee(String f, String l, double s) {
        firstName = f;
        lastName = l;
        salary = (s > 0) ? s : 0;
    }

    // Getter methods
    String getFirstName() { return firstName; }
    String getLastName()  { return lastName; }
    double getSalary()    { return salary; }

    // Setter methods
    void setFirstName(String f) { firstName = f; }
    void setLastName(String l)  { lastName = l; }
    void setSalary(double s)    { salary = (s > 0) ? s : 0; }
}

public class EmployeeTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee 1 Details (firstName lastName monthlySalary):");
        Employee e1 = new Employee(sc.next(), sc.next(), sc.nextDouble());

        System.out.println("Enter Employee 2 Details (firstName lastName monthlySalary):");
        Employee e2 = new Employee(sc.next(), sc.next(), sc.nextDouble());

        // Yearly salary before raise
        System.out.println("\nYearly Salary (Before Raise):");
        System.out.println(e1.getFirstName() + " = " + (e1.getSalary() * 12));
        System.out.println(e2.getFirstName() + " = " + (e2.getSalary() * 12));

        // 10% raise
        e1.setSalary(e1.getSalary() * 1.10);
        e2.setSalary(e2.getSalary() * 1.10);

        // Yearly salary after raise
        System.out.println("\nYearly Salary (After 10% Raise):");
        System.out.println(e1.getFirstName() + " = " + (e1.getSalary() * 12));
        System.out.println(e2.getFirstName() + " = " + (e2.getSalary() * 12));

        sc.close();
    }
}
