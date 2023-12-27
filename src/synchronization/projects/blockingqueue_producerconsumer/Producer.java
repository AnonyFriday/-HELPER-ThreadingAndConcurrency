package synchronization.projects.blockingqueue_producerconsumer;

public class Producer implements Runnable {

    private final Storage storage;

    public Producer(String consumerName, Storage storage) {
        Thread.currentThread().setName(consumerName);
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer item = (int) (Math.random() * 100 + 1);
                storage.produce(item);
                System.out.printf("%n---- Producer %s: %d%n", Thread.currentThread().getName(), item);


                // Printout the current quantity
                System.out.printf("%d/%d", storage.getQueue().size(), storage.getCapacity());

                Thread.sleep(1000); // Simulate production time
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
