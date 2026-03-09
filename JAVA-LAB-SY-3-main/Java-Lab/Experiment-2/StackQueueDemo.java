// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 3: Implementation of stack/queue operations using Interface

import java.util.Scanner;

// Interface for Stack operations
interface StackOperations {
    void push(int item);
    int pop();
    int peek();
    boolean isEmpty();
    boolean isFull();
}

// Interface for Queue operations
interface QueueOperations {
    void enqueue(int item);
    int dequeue();
    boolean isEmpty();
    boolean isFull();
}

// Stack implementation using interface
class Stack implements StackOperations {
    int[] arr;
    int top;
    int capacity;

    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    @Override
    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack Overflow!");
        } else {
            arr[++top] = item;
            System.out.println(item + " pushed to stack.");
        }
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return arr[top--];
    }

    @Override
    public int peek() {
        if (isEmpty()) return -1;
        return arr[top];
    }

    @Override
    public boolean isEmpty() { return top == -1; }

    @Override
    public boolean isFull()  { return top == capacity - 1; }

    void display() {
        if (isEmpty()) { System.out.println("Stack is empty."); return; }
        System.out.print("Stack (top→bottom): ");
        for (int i = top; i >= 0; i--) System.out.print(arr[i] + " ");
        System.out.println();
    }
}

// Queue implementation using interface
class Queue implements QueueOperations {
    int[] arr;
    int front, rear, size, capacity;

    Queue(int cap) {
        arr = new int[cap];
        capacity = cap;
        front = size = 0;
        rear = cap - 1;
    }

    @Override
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full!");
        } else {
            rear = (rear + 1) % capacity;
            arr[rear] = item;
            size++;
            System.out.println(item + " enqueued to queue.");
        }
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public boolean isFull()  { return size == capacity; }

    void display() {
        if (isEmpty()) { System.out.println("Queue is empty."); return; }
        System.out.print("Queue (front→rear): ");
        for (int i = 0; i < size; i++)
            System.out.print(arr[(front + i) % capacity] + " ");
        System.out.println();
    }
}

public class StackQueueDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Stack
        System.out.print("Enter stack size: ");
        Stack stack = new Stack(sc.nextInt());

        System.out.print("Enter number of elements to push: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Push element: ");
            stack.push(sc.nextInt());
        }
        stack.display();
        System.out.println("Popped: " + stack.pop());
        stack.display();

        // Queue
        System.out.print("\nEnter queue size: ");
        Queue queue = new Queue(sc.nextInt());

        System.out.print("Enter number of elements to enqueue: ");
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.print("Enqueue element: ");
            queue.enqueue(sc.nextInt());
        }
        queue.display();
        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();

        sc.close();
    }
}
