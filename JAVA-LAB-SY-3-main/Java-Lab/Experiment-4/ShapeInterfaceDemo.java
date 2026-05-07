// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 3: Implementation of stack/queue operations using Interface
// Program 2: Shape Interface with Rectangle and Triangle

// Shape Interface
interface Shape {
    double area();   // abstract method
}

// Rectangle class implementing Shape
class Rectangle implements Shape {
    double length, breadth;

    Rectangle(double l, double b) {
        length  = l;
        breadth = b;
    }

    @Override
    public double area() {
        return length * breadth;
    }
}

// Triangle class implementing Shape
class Triangle implements Shape {
    double base, height;

    Triangle(double b, double h) {
        base   = b;
        height = h;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

// Main class
public class ShapeInterfaceDemo {
    public static void main(String[] args) {

        // Using interface reference (runtime polymorphism)
        Shape rect     = new Rectangle(10, 5);
        Shape triangle = new Triangle(6, 4);

        System.out.println("===== Shape Area using Interface =====\n");
        System.out.println("Rectangle (length=10, breadth=5):");
        System.out.println("  Area = " + rect.area());

        System.out.println("\nTriangle (base=6, height=4):");
        System.out.println("  Area = " + triangle.area());

        // Array of shapes (polymorphism demo)
        System.out.println("\n-- Polymorphism: Shape Array --");
        Shape[] shapes = { new Rectangle(8, 3), new Triangle(9, 5), new Rectangle(4, 4) };
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Shape[" + i + "] Area = " + shapes[i].area());
        }
    }
}
