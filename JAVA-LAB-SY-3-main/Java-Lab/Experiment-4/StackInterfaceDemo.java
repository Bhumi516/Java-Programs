// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 3: Implementation of stack/queue operations using Interface
// Program 1: Stack Operations using Interface

// Stack Interface
interface Stack {
    int size = 5;  // constant variable

    void push(int item);
    int  pop();
    void display();
    boolean overflow();
    boolean underflow();
}

// IntegerStack class implementing Stack interface
class IntegerStack implements Stack {
    int[] arr;
    int top;

    IntegerStack() {
        arr = new int[size];
        top = -1;
    }

    @Override
    public boolean overflow() {
        return top == size - 1;
    }

    @Override
    public boolean underflow() {
        return top == -1;
    }

    @Override
    public void push(int item) {
        if (overflow()) {
            System.out.println("Stack Overflow! Cannot push " + item);
        } else {
            arr[++top] = item;
            System.out.println(item + " pushed successfully.");
        }
    }

    @Override
    public int pop() {
        if (underflow()) {
            System.out.println("Stack Underflow! Cannot pop.");
            return -1;
        } else {
            int val = arr[top--];
            System.out.println(val + " popped successfully.");
            return val;
        }
    }

    @Override
    public void display() {
        if (underflow()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack (top → bottom): ");
            for (int i = top; i >= 0; i--)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}

// Test class
public class StackInterfaceDemo {
    public static void main(String[] args) {

        IntegerStack stack = new IntegerStack();

        System.out.println("===== Stack Operations =====\n");

        // Test underflow on empty stack
        System.out.println("-- Testing Underflow --");
        System.out.println("Underflow: " + stack.underflow());
        stack.pop();

        System.out.println();

        // Push elements
        System.out.println("-- Pushing Elements --");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println();

        // Display stack
        System.out.println("-- Display Stack --");
        stack.display();

        System.out.println();

        // Test overflow
        System.out.println("-- Testing Overflow --");
        System.out.println("Overflow: " + stack.overflow());
        stack.push(60);   // should trigger overflow message

        System.out.println();

        // Pop elements
        System.out.println("-- Popping Elements --");
        stack.pop();
        stack.pop();

        System.out.println();

        // Display after pop
        System.out.println("-- Display After Pop --");
        stack.display();
    }
}
