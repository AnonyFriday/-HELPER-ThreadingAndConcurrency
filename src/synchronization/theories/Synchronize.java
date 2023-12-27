package synchronization.theories;


/**
 * Field visibility issues
 * - Using synchronize method, block, object to lock
 * the share resources, notify other waited thread to execute
 *
 * @param <T>
 */
public class Synchronize<T> {
    private boolean changed;
    private T value;

    public Synchronize(T value) {
        this.value = value;
    }

    public synchronized void set(T newValue) {

        // after changing the value from shared resources,
        // notify all thread at the waiting sets to joining the monitor

        value = newValue;
        changed = true;
        notifyAll();
    }

    public synchronized T get() {

        // If changed not happen, than this thread will be
        // located at the wait sets, until someone being notified
        while (!changed) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        changed = false;
        return value;
    }


    public static void main(String[] args) {
        Synchronize<Integer> sync = new Synchronize<>(20);


        new Thread(() -> sync.set(30)).start();


        new Thread(() -> System.out.println(sync.get())).start();
        new Thread(() -> System.out.println(sync.get())).start();
        new Thread(() -> System.out.println(sync.get())).start();
        new Thread(() -> System.out.println(sync.get())).start();
        new Thread(() -> sync.set(40)).start();
        new Thread(() -> sync.set(50)).start();
        new Thread(() -> sync.set(60)).start();
        new Thread(() -> sync.set(70)).start();

    }
}
