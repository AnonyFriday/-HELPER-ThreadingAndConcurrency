package synchronization.projects.blockingqueue_producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Storage {
    private final BlockingQueue<Integer> queue;
    private final int capacity;

    public Storage(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
        this.capacity = capacity;
    }

    public void produce(int item) throws InterruptedException {
        queue.put(item);
    }

    public int consume() throws InterruptedException {
        return queue.take();
    }

    public BlockingQueue<Integer> getQueue() {
        return this.queue;
    }

    public int getCapacity() {
        return capacity;
    }
}
