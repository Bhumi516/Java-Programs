// Name   : Bhumi Bhadre
// Roll No: 31
// Experiment 10: Design and develop an application for demonstration of multithreading
// Program 2: Inter-thread Communication — Producer-Consumer using wait() and notify()

public class ProducerConsumerDemo {

    // ====================================================
    // Shared Buffer — critical section
    // ====================================================
    static class SharedBuffer {
        private int data;
        private boolean hasData = false;

        // Called by Producer: waits if buffer is full
        synchronized void produce(int value) throws InterruptedException {
            while (hasData) {
                System.out.println("  [Producer] Buffer full — waiting...");
                wait(); // release lock and wait
            }
            data    = value;
            hasData = true;
            System.out.println("  [Producer] Produced: " + value);
            notify(); // wake up Consumer
        }

        // Called by Consumer: waits if buffer is empty
        synchronized int consume() throws InterruptedException {
            while (!hasData) {
                System.out.println("  [Consumer] Buffer empty — waiting...");
                wait(); // release lock and wait
            }
            hasData = false;
            System.out.println("  [Consumer] Consumed: " + data);
            notify(); // wake up Producer
            return data;
        }
    }

    // ====================================================
    // Producer Thread
    // ====================================================
    static class Producer extends Thread {
        private SharedBuffer buffer;
        private int items;

        Producer(SharedBuffer buffer, int items) {
            this.buffer = buffer;
            this.items  = items;
            setName("Producer");
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= items; i++) {
                    buffer.produce(i * 10);
                    Thread.sleep(200); // simulate production time
                }
            } catch (InterruptedException e) {
                System.out.println("[Producer] Interrupted.");
            }
            System.out.println("[Producer] Done producing.");
        }
    }

    // ====================================================
    // Consumer Thread
    // ====================================================
    static class Consumer extends Thread {
        private SharedBuffer buffer;
        private int items;
        private int total = 0;

        Consumer(SharedBuffer buffer, int items) {
            this.buffer = buffer;
            this.items  = items;
            setName("Consumer");
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= items; i++) {
                    total += buffer.consume();
                    Thread.sleep(300); // simulate consumption time
                }
            } catch (InterruptedException e) {
                System.out.println("[Consumer] Interrupted.");
            }
            System.out.println("[Consumer] Done consuming. Total sum = " + total);
        }
    }

    // ====================================================
    // Demo: Deadlock Demonstration (for understanding)
    // ====================================================
    static class DeadlockDemo {
        static final Object LOCK1 = new Object();
        static final Object LOCK2 = new Object();

        static void showDeadlockRisk() {
            System.out.println("\n--- Deadlock Risk Demo (timeout after 2 sec) ---");

            Thread t1 = new Thread(() -> {
                synchronized (LOCK1) {
                    System.out.println("  [T1] Holding LOCK1, waiting for LOCK2...");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    synchronized (LOCK2) {
                        System.out.println("  [T1] Acquired both locks.");
                    }
                }
            }, "T1");

            Thread t2 = new Thread(() -> {
                synchronized (LOCK2) {
                    System.out.println("  [T2] Holding LOCK2, waiting for LOCK1...");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    synchronized (LOCK1) {
                        System.out.println("  [T2] Acquired both locks.");
                    }
                }
            }, "T2");

            t1.setDaemon(true); // daemon threads auto-terminate
            t2.setDaemon(true);
            t1.start();
            t2.start();

            try {
                t1.join(2000); // wait max 2 seconds
                t2.join(2000);
                if (t1.isAlive() || t2.isAlive()) {
                    System.out.println("  [Main] Possible DEADLOCK detected! Threads still alive.");
                }
            } catch (InterruptedException e) {}
        }
    }

    // ====================================================
    // Main method
    // ====================================================
    public static void main(String[] args) throws InterruptedException {

        System.out.println("===== Producer-Consumer Demo — Bhumi Bhadre, Roll No: 31 =====\n");

        // ---- Producer-Consumer ----
        System.out.println("=== Part 1: Producer-Consumer using wait() / notify() ===");
        SharedBuffer buffer = new SharedBuffer();
        int ITEMS = 5;

        Producer producer = new Producer(buffer, ITEMS);
        Consumer consumer = new Consumer(buffer, ITEMS);

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("\n[Main] Producer-Consumer completed successfully.");

        // ---- Deadlock demo ----
        System.out.println("\n=== Part 2: Deadlock Awareness Demo ===");
        DeadlockDemo.showDeadlockRisk();

        System.out.println("\n===== Program Complete =====");
    }
}

