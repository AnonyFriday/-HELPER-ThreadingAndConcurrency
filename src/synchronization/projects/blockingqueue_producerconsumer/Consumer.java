package synchronization.projects.blockingqueue_producerconsumer;

public class Consumer implements Runnable {

    private final Storage storage;

    public Consumer(String consumerName, Storage storage) {
        Thread.currentThread().setName(consumerName);
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer item = (Integer) storage.consume();
                System.out.printf("%n---- Consumer %s: %d%n", Thread.currentThread().getName(), item);


                // Printout the current quantity
                System.out.printf("%d/%d", storage.getQueue().size(), storage.getCapacity());

                Thread.sleep(5000); // Simulate the consumption time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
