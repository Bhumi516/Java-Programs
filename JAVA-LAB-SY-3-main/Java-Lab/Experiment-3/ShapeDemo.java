// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 2: Design and develop programs for different types of inheritance
// Program 3: Abstract class inheritance — Shape → Rectangle, Triangle

abstract class Shape {
    double dim1, dim2;

    Shape(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    abstract double area();
}

class Rectangle extends Shape {
    Rectangle(double l, double w) { super(l, w); }

    @Override
    double area() { return dim1 * dim2; }
}

class Triangle extends Shape {
    Triangle(double base, double height) { super(base, height); }

    @Override
    double area() { return 0.5 * dim1 * dim2; }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(10, 5);
        Triangle t  = new Triangle(6, 4);

        System.out.println("Area of Rectangle = " + r.area());
        System.out.println("Area of Triangle  = " + t.area());
    }
}
