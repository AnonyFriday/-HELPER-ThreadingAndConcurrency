package synchronization.projects.lock_parallelvectorsum;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. The scope of this project is to sum all nums from left to right
 * 2. Using Lock for synchronization 2 threads
 * 3. Two threads tackle a half of a range to sum the final result
 */
public class Main {


    // ===============================
    // == Fields
    // ===============================

    public static int sharedSum = 0;
    public static int[] arr = new int[100];
    public static final Lock locker = new ReentrantLock();

    public static void main(String[] args) {

        int sliceThread = arr.length / 2; // 5


        // Slicing the array by 2 half processed by 2 threads
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new WorkerThread((i * sliceThread), (i + 1) * (sliceThread) - 1));
            thread.start();
            try {
                // Using thread join to let the current main thread waiting this one to finish before printing out the result
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Print out the final result
        System.out.println("Final result: " + sharedSum);
    }

    // ===============================
    // == Methods
    // ===============================


    /**
     * A thread class for calculating the sum in range
     */
    private static class WorkerThread implements Runnable {

        private final int left;
        private final int right;

        public WorkerThread(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public void run() {
            for (int i = left; i <= right; i++) {
                locker.lock();
                sharedSum += i;
                System.out.println("Sum: " + sharedSum + " from thread: " + Thread.currentThread().threadId());
                locker.unlock();
            }


        }
    }
}
