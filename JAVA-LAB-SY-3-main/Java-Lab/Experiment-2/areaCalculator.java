// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 1: Implementation of a problem statement using class and object
// Program 2: Rectangle area using setDim() and getArea() methods

import java.util.*;

class Area {

    double length;
    double breadth;

    void setDim(double l, double b) {
        length = l;
        breadth = b;
    }

    double getArea() {
        return length * breadth;
    }
}

public class areaCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Area rect = new Area();

        System.out.print("Enter length: ");
        double l = sc.nextDouble();

        System.out.print("Enter breadth: ");
        double b = sc.nextDouble();

        rect.setDim(l, b);
        System.out.println("Area of Rectangle = " + rect.getArea());

        sc.close();
    }
}
