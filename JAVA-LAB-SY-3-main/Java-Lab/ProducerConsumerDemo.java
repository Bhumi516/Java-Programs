// Name   : Prachi Chavan
// Roll No: 44
// Experiment 10: Design and develop an application for demonstration of multithreading
// Program 1: Thread creation — extending Thread class and implementing Runnable
//            Thread lifecycle, sleep, join, priority

public class MultithreadingDemo {

    // ====================================================
    // Method 1: Extending Thread class
    // ====================================================
    static class CounterThread extends Thread {
        private String name;
        private int limit;
        private int delay; // milliseconds

        CounterThread(String name, int limit, int delay) {
            this.name  = name;
            this.limit = limit;
            this.delay = delay;
        }

        @Override
        public void run() {
            System.out.println("[" + name + "] Thread started. Priority: " + getPriority());
            for (int i = 1; i <= limit; i++) {
                System.out.println("[" + name + "] Count: " + i);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println("[" + name + "] Interrupted!");
                    return;
                }
            }
            System.out.println("[" + name + "] Thread finished.");
        }
    }

    // ====================================================
    // Method 2: Implementing Runnable interface
    // ====================================================
    static class PrintTask implements Runnable {
        private String message;
        private int    times;

        PrintTask(String message, int times) {
            this.message = message;
            this.times   = times;
        }

        @Override
        public void run() {
            String tName = Thread.currentThread().getName();
            System.out.println("[" + tName + "] Runnable task started.");
            for (int i = 1; i <= times; i++) {
                System.out.println("[" + tName + "] " + message + " (" + i + ")");
                try { Thread.sleep(300); }
                catch (InterruptedException e) { return; }
            }
            System.out.println("[" + tName + "] Runnable task finished.");
        }
    }

    // ====================================================
    // Demo 1: Basic thread creation and joining
    // ====================================================
    static void demo1BasicThreads() throws InterruptedException {
        System.out.println("\n============================================================");
        System.out.println("DEMO 1: Basic Thread Creation");
        System.out.println("============================================================");

        // Create threads using Thread class
        CounterThread t1 = new CounterThread("Thread-A", 4, 200);
        CounterThread t2 = new CounterThread("Thread-B", 4, 300);

        // Create thread using Runnable
        Thread t3 = new Thread(new PrintTask("Hello from Runnable", 3), "Thread-C");

        // Start threads
        t1.start();
        t2.start();
        t3.start();

        // join() — main waits for all threads to finish
        t1.join();
        t2.join();
        t3.join();

        System.out.println("\n[Main] All threads completed.");
    }

    // ====================================================
    // Demo 2: Thread priority
    // ====================================================
    static void demo2Priority() throws InterruptedException {
        System.out.println("\n============================================================");
        System.out.println("DEMO 2: Thread Priority");
        System.out.println("============================================================");

        CounterThread low    = new CounterThread("LOW-Priority",    3, 100);
        CounterThread normal = new CounterThread("NORMAL-Priority", 3, 100);
        CounterThread high   = new CounterThread("HIGH-Priority",   3, 100);

        low.setPriority(Thread.MIN_PRIORITY);     // 1
        normal.setPriority(Thread.NORM_PRIORITY); // 5
        high.setPriority(Thread.MAX_PRIORITY);    // 10

        System.out.println("MIN_PRIORITY = " + Thread.MIN_PRIORITY);
        System.out.println("NORM_PRIORITY= " + Thread.NORM_PRIORITY);
        System.out.println("MAX_PRIORITY = " + Thread.MAX_PRIORITY);

        low.start();
        normal.start();
        high.start();

        low.join();
        normal.join();
        high.join();
        System.out.println("\n[Main] Priority demo done.");
    }

    // ====================================================
    // Demo 3: Synchronization — shared counter
    // ====================================================
    static class SharedCounter {
        private int count = 0;

        // synchronized prevents race condition
        synchronized void increment(String threadName) {
            count++;
            System.out.println("[" + threadName + "] count = " + count);
        }

        int getCount() { return count; }
    }

    static class IncrementTask implements Runnable {
        private SharedCounter counter;
        private String        name;

        IncrementTask(SharedCounter counter, String name) {
            this.counter = counter;
            this.name    = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                counter.increment(name);
                try { Thread.sleep(50); }
                catch (InterruptedException e) { return; }
            }
        }
    }

    static void demo3Synchronization() throws InterruptedException {
        System.out.println("\n============================================================");
        System.out.println("DEMO 3: Synchronization (Shared Counter)");
        System.out.println("============================================================");

        SharedCounter counter = new SharedCounter();

        Thread t1 = new Thread(new IncrementTask(counter, "ThreadX"), "ThreadX");
        Thread t2 = new Thread(new IncrementTask(counter, "ThreadY"), "ThreadY");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("\nFinal Count (expected 10): " + counter.getCount());
    }

    // ====================================================
    // Demo 4: Thread lifecycle states
    // ====================================================
    static void demo4Lifecycle() throws InterruptedException {
        System.out.println("\n============================================================");
        System.out.println("DEMO 4: Thread Lifecycle States");
        System.out.println("============================================================");

        Thread t = new Thread(() -> {
            System.out.println("  [Thread] Running — State: " + Thread.currentThread().getState());
            try { Thread.sleep(500); }
            catch (InterruptedException e) {}
            System.out.println("  [Thread] Finishing — State: " + Thread.currentThread().getState());
        }, "LifecycleThread");

        System.out.println("After new     → State: " + t.getState());   // NEW

        t.start();
        System.out.println("After start() → State: " + t.getState()); // RUNNABLE

        Thread.sleep(100);
        System.out.println("While sleeping→ State: " + t.getState());  // TIMED_WAITING

        t.join();
        System.out.println("After join()  → State: " + t.getState());  // TERMINATED
    }

    // ====================================================
    // Main method
    // ====================================================
    public static void main(String[] args) throws InterruptedException {
        System.out.println("===== Multithreading Demo — Prachi Chavan, Roll No: 44 =====");

        demo1BasicThreads();
        demo2Priority();
        demo3Synchronization();
        demo4Lifecycle();

        System.out.println("\n===== All Demos Complete =====");
    }
}
