package synchronization.projects.blockingqueue_producerconsumer;


import java.util.SortedMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The queue that implements
 * atomic operations or synchronize under the hood
 * <p>
 * Implements wait(), notify(), notifyAll() based on monitor and locking behavior
 */
public class Main {

    public static void main(String[] args) {

        Storage storage = new Storage(20);

        Thread consumer1 = new Thread(new Consumer("C1", storage));
        Thread consumer2 = new Thread(new Consumer("C2", storage));
        Thread consumer3 = new Thread(new Consumer("C3", storage));

        Thread producer1 = new Thread(new Producer("P1", storage));
        Thread producer2 = new Thread(new Producer("P1", storage));

        consumer3.start();
        consumer1.start();
        consumer2.start();

        producer1.start();
        producer2.start();

    }
}
